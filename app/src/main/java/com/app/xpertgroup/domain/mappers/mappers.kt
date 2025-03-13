package com.app.xpertgroup.domain.mappers

import com.app.xpertgroup.data.model.AddressEntity
import com.app.xpertgroup.data.model.GeoEntity
import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.domain.databaseEntities.AddressDBEntity
import com.app.xpertgroup.domain.databaseEntities.AddressWithGeo
import com.app.xpertgroup.domain.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.domain.databaseEntities.GeoDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserDBEntity
import com.app.xpertgroup.domain.databaseEntities.UserFull
import com.app.xpertgroup.domain.model.Address
import com.app.xpertgroup.domain.model.Company
import com.app.xpertgroup.domain.model.CompanyEntity
import com.app.xpertgroup.domain.model.Geo
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

fun List<UserFull>.listUserFullToListUserEntity():List<UserEntity> = this.map {
    it.run {
        it.toUserEntity()
    }
}


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

fun UserFull.toUserEntity(): UserEntity {
    return UserEntity(
        id = user.id,
        name = user.name,
        userName = user.username,
        email = user.email,
        phone = user.phone,
        website = user.website,
        company = company?.toCompanyEntity(),
        address = addressWithGeo?.toAddressEntity()
    )
}

fun AddressWithGeo.toAddressEntity(): AddressEntity = AddressEntity(
    street = address.street,
    suite = address.suite,
    city = address.city,
    zipCode = address.zipcode,
    geo = geo?.toGeoEntity()
)

fun GeoDBEntity.toGeoEntity(): GeoEntity = GeoEntity(
    lat, lng
)

fun CompanyDBEntity.toCompanyEntity() : CompanyEntity = CompanyEntity(
    name,
    catchPhrase,
    bs
)

fun GeoEntity.toGeoDBEntity(): GeoDBEntity = GeoDBEntity(
    // geoId is auto-generated so we can leave it as default (0) here.
    lat = this.lat,
    lng = this.lng
)

fun AddressEntity.toAddressDBEntity(geoId: Long): AddressDBEntity = AddressDBEntity(
    // addressId is auto-generated so we use default value.
    street = this.street,
    suite = this.suite,
    city = this.city,
    zipcode = this.zipCode,
    geoId = geoId
)

fun CompanyEntity.toCompanyDBEntity(): CompanyDBEntity = CompanyDBEntity(
    // Providing a default empty string if name is null.
    name = this.name ?: "",
    catchPhrase = this.catchPhrase,
    bs = this.bs
)

fun UserEntity.toUserDBEntity(addressId: Long): UserDBEntity = UserDBEntity(
    id = this.id.toString(),
    name = this.name,
    username = this.userName,
    email = this.email,
    phone = this.phone,
    website = this.website,
    addressId = addressId,
    companyName = this.company?.name
)