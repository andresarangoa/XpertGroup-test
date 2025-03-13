package com.app.xpertgroup.data.remote.model

interface Company {
    val name: String?
    val catchPhrase: String?
    val bs: String?
}

class CompanyResponse(
    override var name: String? = null,
    override var catchPhrase: String? = null,
    override var bs: String? = null
) : Company
