package com.app.xpertgroup.domain.repository

import com.app.xpertgroup.domain.model.User
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object {
        private const val USERS = "users"
    }

    @GET(USERS)
    fun getUsers(): Call<List<User>>
}