package com.app.xpertgroup.data

import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.daos.AddressDao
import com.app.xpertgroup.domain.daos.CompanyDao
import com.app.xpertgroup.domain.daos.GeoDao
import com.app.xpertgroup.domain.daos.UserDao
import com.app.xpertgroup.domain.databaseEntities.AddressDBEntity
import com.app.xpertgroup.domain.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.domain.databaseEntities.GeoDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserFull
import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.domain.datasource.UsersRemoteDatasource
import com.app.xpertgroup.domain.mappers.toListUserDBEntity
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
            // Save Geo data
            val geoId = geoDao.insertGeo(
                GeoDBEntity(
                    lat = user.address?.geo?.lat,
                    lng = user.address?.geo?.lng
                )
            )

            // Save Address with the geoId
            val addressId = addressDao.insertAddress(
                AddressDBEntity(
                    street = user.address?.street,
                    suite = user.address?.suite,
                    city = user.address?.city,
                    zipcode = user.address?.zipCode,
                    geoId = geoId
                )
            )

            // Save Company data
            companyDao.insertCompany(
                CompanyDBEntity(
                    name = user.company?.name ?: "",
                    catchPhrase = user.company?.catchPhrase,
                    bs = user.company?.bs
                )
            )

            // Save User data with the addressId and companyName
            userDao.insertUser(
                UserDBEntity(
                    id = user.id.toString(),
                    name = user.name,
                    username = user.userName,
                    email = user.email,
                    phone = user.phone,
                    website = user.website,
                    addressId = addressId,
                    companyName = user.company?.name
                )
            )
        }
    }
}


class UsersRemoteDataSourceImp(
    private val usersApi: Api
) : UsersRemoteDatasource {
    override fun getUsers(): Call<List<UserResponse>> = usersApi.getUsers()
}