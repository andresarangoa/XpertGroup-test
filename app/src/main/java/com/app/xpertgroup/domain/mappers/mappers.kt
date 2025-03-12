package com.app.xpertgroup.domain.mappers


import com.app.xpertgroup.data.model.AddressEntity
import com.app.xpertgroup.data.model.GeoEntity
import com.app.xpertgroup.domain.model.Address
import com.app.xpertgroup.domain.model.Company
import com.app.xpertgroup.domain.model.Geo
import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.model.CompanyEntity
import com.app.xpertgroup.domain.model.User

fun User.toUserEntity(): UserEntity =
    UserEntity(
        id,
        name,
        userName,
        email,
        address?.toAddressEntity(),
        phone,
        website,
        company?.toCompanyEntity(),
    )

fun Address.toAddressEntity() : AddressEntity = AddressEntity(
    street,
    suite,
    city,
    zipCode,
    geo?.toGeoEntity()
)

fun Company.toCompanyEntity() : CompanyEntity = CompanyEntity(
    name,
    catchPhrase,
    bs
)

fun Geo.toGeoEntity(): GeoEntity = GeoEntity(
    lat, lng
)

fun List<User>.toListUserEntity():List<UserEntity> = this.map {
    it.run {
        it.toUserEntity()
    }
}