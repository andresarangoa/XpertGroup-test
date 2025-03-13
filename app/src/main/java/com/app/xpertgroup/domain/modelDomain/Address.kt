package com.app.xpertgroup.domain.modelDomain

data class AddressEntity(
   var street: String? = null,
   var suite: String? = null,
   var city: String? = null,
   var zipCode: String? = null,
   var geo: GeoEntity? = null
)