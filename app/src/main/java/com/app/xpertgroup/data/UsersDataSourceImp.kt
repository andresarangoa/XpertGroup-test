package com.app.xpertgroup.data

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.daos.AddressDao
import com.app.xpertgroup.domain.daos.CompanyDao
import com.app.xpertgroup.domain.daos.GeoDao
import com.app.xpertgroup.domain.daos.UserDao
import com.app.xpertgroup.domain.databaseEntities.AddressDBEntity
import com.app.xpertgroup.domain.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.domain.databaseEntities.GeoDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserFull
import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.domain.mappers.toAddressDBEntity
import com.app.xpertgroup.domain.mappers.toCompanyDBEntity
import com.app.xpertgroup.domain.mappers.toGeoDBEntity
import com.app.xpertgroup.domain.mappers.toUserDBEntity
import com.app.xpertgroup.domain.model.UserResponse
import com.app.xpertgroup.domain.repository.Api
import retrofit2.Call

class UsersLocalDataSourceImp(
    private val userDao: UserDao,
    private val geoDao: GeoDao,
    private val addressDao: AddressDao,
    private val companyDao: CompanyDao
) : UsersLocalDataSource {

    override suspend fun getUsers(): List<UserFull> {
        return userDao.getAllUsersFull()
    }

    override suspend fun saveUsers(users: List<UserEntity>) {
        for (user in users) {
            val geoId = geoDao.insertGeo(
                user.address?.geo?.toGeoDBEntity() ?: GeoDBEntity()
            )
            val addressId = addressDao.insertAddress(
                user.address?.toAddressDBEntity(geoId) ?: AddressDBEntity()
            )

            companyDao.insertCompany(user.company?.toCompanyDBEntity() ?: CompanyDBEntity())

            userDao.insertUser(user.toUserDBEntity(addressId))

        }
    }

    override suspend fun getUsersByName(name: String): List<UserFull> {
        return userDao.getUsersByName(name)
    }
}


class UsersRemoteDataSourceImp(
    private val usersApi: Api
) : UsersRemoteDatasource {
    override fun getUsers(): Call<List<UserResponse>> = usersApi.getUsers()
}