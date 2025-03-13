package com.app.xpertgroup.ui.utils

import com.app.xpertgroup.data.model.AddressEntity
import com.app.xpertgroup.data.model.GeoEntity
import com.app.xpertgroup.data.model.UserEntity
import com.app.xpertgroup.data.model.CompanyEntity

val sampleUser = UserEntity(
    id = "1",
    name = "Leanne Graham",
    userName = "Bret",
    email = "Sincere@april.biz",
    address = AddressEntity(
        street = "Kulas Light",
        suite = "Apt. 556",
        city = "Gwenborough",
        zipCode = "92998-3874",
        geo = GeoEntity(
            lat = "-37.3159",
            lng = "81.1496"
        )
    ),
    phone = "1-770-736-8031 x56442",
    website = "hildegard.org",
    company = CompanyEntity(
        name = "Romaguera-Crona",
        catchPhrase = "Multi-layered client-server neural-net",
        bs = "harness real-time e-markets"
    )
)