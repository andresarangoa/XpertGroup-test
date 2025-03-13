package com.app.xpertgroup.data.remote.model

import com.google.gson.annotations.SerializedName

interface User {
    val id:String?
    val name:String?
    val userName:String?
    val email:String?
    val address: Address?
    val phone: String?
    val website: String?
    val company: Company?
}


data class UserResponse(
    override var id: String? = null,
    override var name: String? = null,

    @SerializedName("username")
    override var userName: String?=null,

    override var email: String? = null,
    override var address: AddressResponse? = null,
    override var phone: String? = null,
    override var website: String? = null,
    override var company: CompanyResponse? = null
) : User
