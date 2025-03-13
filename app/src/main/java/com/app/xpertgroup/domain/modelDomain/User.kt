package com.app.xpertgroup.domain.modelDomain

data class UserEntity(
    var id: String? = null,
    var name: String? = null,
    var userName: String? = null,
    var email: String? = null,
    var address: AddressEntity? = null,
    var phone: String? = null,
    var website: String? = null,
    var company: CompanyEntity? = null
)
