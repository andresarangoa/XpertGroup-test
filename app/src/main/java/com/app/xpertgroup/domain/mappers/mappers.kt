package com.app.xpertgroup.domain.mappers


import android.R
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

fun List<UserEntity>.toListUserDBEntity() = this.map {
    it.run {

    }
}


fun List<UserFull>.listUserFullToListUserEntity():List<UserEntity> = this.map {
    it.run {
        it.toUserEntity()
    }
}

fun Address.toAddressDBEntity(userId:String = "") : AddressDBEntity = AddressDBEntity(
    street = street,
    suite =suite,
    city = city,
    zipcode = zipCode,
)

fun Company.toCompanyEntity() : CompanyEntity = CompanyEntity(
    name,
    catchPhrase,
    bs
)

fun Geo.toGeoEntity(): GeoEntity = GeoEntity(
    lat, lng
)

fun Geo.toGeoDBEntity(): GeoDBEntity = GeoDBEntity(
    lat= lat, lng = lng
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

fun User.toUserDBEntity(): UserDBEntity =
    UserDBEntity(
        id = id?:"",
        name= name,
        username = userName,
        email = email,
        phone = phone,
        website =  website,
        companyName = company?.name
    )