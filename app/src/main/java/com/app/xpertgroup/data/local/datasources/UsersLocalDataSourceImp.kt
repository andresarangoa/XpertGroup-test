package com.app.xpertgroup.data.local.datasources

import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.data.local.daos.AddressDao
import com.app.xpertgroup.data.local.daos.CompanyDao
import com.app.xpertgroup.data.local.daos.GeoDao
import com.app.xpertgroup.data.local.daos.UserDao
import com.app.xpertgroup.data.local.databaseEntities.AddressDBEntity
import com.app.xpertgroup.data.local.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.data.local.databaseEntities.GeoDBEntity
import com.app.xpertgroup.data.local.databaseEntities.UserFull
import com.app.xpertgroup.domain.datasource.UsersLocalDataSource
import com.app.xpertgroup.data.mappers.toAddressDBEntity
import com.app.xpertgroup.data.mappers.toCompanyDBEntity
import com.app.xpertgroup.data.mappers.toGeoDBEntity
import com.app.xpertgroup.data.mappers.toUserDBEntity

class UsersLocalDataSourceImp(
    private val userDao: UserDao,
    private val geoDao: GeoDao,
    private val addressDao: AddressDao,
    private val companyDao: CompanyDao
) : UsersLocalDataSource {

    override suspend fun getUsers(): List<UserFull> {
        return userDao.getAllUsersFull()
    }

    override suspend fun saveUsers(users: List<UserDomain>) {
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