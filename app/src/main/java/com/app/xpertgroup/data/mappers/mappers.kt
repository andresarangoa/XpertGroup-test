package com.app.xpertgroup.data.mappers

import com.app.xpertgroup.domain.modelDomain.AddressDomain
import com.app.xpertgroup.domain.modelDomain.GeoDomain
import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.data.local.databaseEntities.AddressDBEntity
import com.app.xpertgroup.data.local.databaseEntities.AddressWithGeo
import com.app.xpertgroup.data.local.databaseEntities.CompanyDBEntity
import com.app.xpertgroup.data.local.databaseEntities.GeoDBEntity
import com.app.xpertgroup.data.local.databaseEntities.UserDBEntity
import com.app.xpertgroup.data.local.databaseEntities.UserFull
import com.app.xpertgroup.data.remote.model.Address
import com.app.xpertgroup.data.remote.model.Company
import com.app.xpertgroup.domain.modelDomain.CompanyDomain
import com.app.xpertgroup.data.remote.model.Geo
import com.app.xpertgroup.data.remote.model.User


fun User.toUserEntity(): UserDomain =
    UserDomain(
        id,
        name,
        userName,
        email,
        address?.toAddressEntity(),
        phone,
        website,
        company?.toCompanyEntity(),
    )

fun Address.toAddressEntity() : AddressDomain = AddressDomain(
    street,
    suite,
    city,
    zipCode,
    geo?.toGeoEntity()
)

fun List<UserFull>.listUserFullToListUserEntity():List<UserDomain> = this.map {
    it.run {
        it.toUserEntity()
    }
}

fun Company.toCompanyEntity() : CompanyDomain = CompanyDomain(
    name,
    catchPhrase,
    bs
)

fun Geo.toGeoEntity(): GeoDomain = GeoDomain(
    lat, lng
)

fun List<User>.toListUserEntity():List<UserDomain> = this.map {
    it.run {
        it.toUserEntity()
    }
}

fun UserFull.toUserEntity(): UserDomain {
    return UserDomain(
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

fun AddressWithGeo.toAddressEntity(): AddressDomain = AddressDomain(
    street = address.street,
    suite = address.suite,
    city = address.city,
    zipCode = address.zipcode,
    geo = geo?.toGeoEntity()
)

fun GeoDBEntity.toGeoEntity(): GeoDomain = GeoDomain(
    lat, lng
)

fun CompanyDBEntity.toCompanyEntity() : CompanyDomain = CompanyDomain(
    name,
    catchPhrase,
    bs
)

fun GeoDomain.toGeoDBEntity(): GeoDBEntity = GeoDBEntity(
    // geoId is auto-generated so we can leave it as default (0) here.
    lat = this.lat,
    lng = this.lng
)

fun AddressDomain.toAddressDBEntity(geoId: Long): AddressDBEntity = AddressDBEntity(
    // addressId is auto-generated so we use default value.
    street = this.street,
    suite = this.suite,
    city = this.city,
    zipcode = this.zipCode,
    geoId = geoId
)

fun CompanyDomain.toCompanyDBEntity(): CompanyDBEntity = CompanyDBEntity(
    // Providing a default empty string if name is null.
    name = this.name ?: "",
    catchPhrase = this.catchPhrase,
    bs = this.bs
)

fun UserDomain.toUserDBEntity(addressId: Long): UserDBEntity = UserDBEntity(
    id = this.id.toString(),
    name = this.name,
    username = this.userName,
    email = this.email,
    phone = this.phone,
    website = this.website,
    addressId = addressId,
    companyName = this.company?.name
)