package com.app.xpertgroup.ui.utils

import com.app.xpertgroup.domain.modelDomain.AddressDomain
import com.app.xpertgroup.domain.modelDomain.GeoDomain
import com.app.xpertgroup.domain.modelDomain.UserDomain
import com.app.xpertgroup.domain.modelDomain.CompanyDomain

val sampleUser = UserDomain(
    id = "1",
    name = "Leanne Graham",
    userName = "Bret",
    email = "Sincere@april.biz",
    address = AddressDomain(
        street = "Kulas Light",
        suite = "Apt. 556",
        city = "Gwenborough",
        zipCode = "92998-3874",
        geo = GeoDomain(
            lat = "-37.3159",
            lng = "81.1496"
        )
    ),
    phone = "1-770-736-8031 x56442",
    website = "hildegard.org",
    company = CompanyDomain(
        name = "Romaguera-Crona",
        catchPhrase = "Multi-layered client-server neural-net",
        bs = "harness real-time e-markets"
    )
)