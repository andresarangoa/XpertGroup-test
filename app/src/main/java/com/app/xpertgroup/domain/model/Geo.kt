package com.app.xpertgroup.domain.model

interface Geo {
    val lat: String?
    val lng: String?
}

class GeoDtoImp(
    override var lat: String? = null,
    override var lng: String? = null
) : Geo