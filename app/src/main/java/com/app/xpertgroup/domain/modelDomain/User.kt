package com.app.xpertgroup.domain.modelDomain

data class UserDomain(
    var id: String? = null,
    var name: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var address: AddressDomain? = null,
    var phone: String? = null,
    var website: String? = null,
    var company: CompanyDomain? = null
)
