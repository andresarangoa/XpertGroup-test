package com.app.xpertgroup.data.model

import com.app.xpertgroup.domain.model.Geo

data class AddressEntity(
   var street: String? = null,
   var suite: String? = null,
   var city: String? = null,
   var zipCode: String? = null,
   var geo: GeoEntity? = null
)