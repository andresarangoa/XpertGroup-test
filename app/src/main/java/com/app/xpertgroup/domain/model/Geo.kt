package com.app.xpertgroup.domain.model

interface Geo {
    val lat: String?
    val lng: String?
}

class GeoResponse(
    override var lat: String? = null,
    override var lng: String? = null
) : Geo