package com.app.xpertgroup.data.databaseEntities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = CompanyDBEntity::class,
            parentColumns = ["name"],
            childColumns = ["companyName"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = AddressDBEntity::class,
            parentColumns = ["addressId"],
            childColumns = ["addressId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["companyName"]), Index(value = ["addressId"])]
)
data class UserDBEntity(
    @PrimaryKey val id: String ,
    val name: String?,
    val username: String?,
    val email: String?,
    val phone: String?,
    val website: String?,
    val addressId: Long = 0,
    val companyName: String?
)

data class AddressWithGeo(
    @Embedded val address: AddressDBEntity,
    @Relation(
        parentColumn = "geoId",
        entityColumn = "geoId"
    )
    val geo: GeoDBEntity?
)

data class UserFull(
    @Embedded val user: UserDBEntity,
    @Relation(
        parentColumn = "addressId",
        entityColumn = "addressId",
        entity = AddressDBEntity::class
    )
    val addressWithGeo: AddressWithGeo?,
    @Relation(
        parentColumn = "companyName",
        entityColumn = "name"
    )
    val company: CompanyDBEntity?
)