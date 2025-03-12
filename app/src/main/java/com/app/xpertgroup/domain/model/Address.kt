package com.app.xpertgroup.domain.model

interface Address {
    val street: String?
    val suite: String?
    val city: String?
    val zipCode: String?
    val geo: Geo?
}

data class AddressResponse(
    override var street: String? = null,
    override var suite: String? = null,
    override var city: String? = null,
    override var zipCode: String? = null,
    override var geo: GeoResponse? = null
) : Address