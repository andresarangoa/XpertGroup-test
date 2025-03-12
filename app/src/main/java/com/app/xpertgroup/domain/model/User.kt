package com.app.xpertgroup.domain.model

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

class UserDtoImp(
    override var id: String? = null,
    override var name: String? = null,
    override var userName: String? = null,
    override var email: String? = null,
    override var address: Address? = null,
    override var phone: String? = null,
    override var website: String? = null,
    override var company: Company? = null
) : User
