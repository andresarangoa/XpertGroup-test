package com.app.xpertgroup.data.local.databaseEntities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "addresses",
    foreignKeys = [
        ForeignKey(
            entity = GeoDBEntity::class,
            parentColumns = ["geoId"],
            childColumns = ["geoId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["geoId"])]
)
data class AddressDBEntity(
    @PrimaryKey(autoGenerate = true) val addressId: Long = 0,
    val street: String? = "",
    val suite: String? = "",
    val city: String? = "",
    val zipcode: String?= "",
    val geoId: Long = 0
)