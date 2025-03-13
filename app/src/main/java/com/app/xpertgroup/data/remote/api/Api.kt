package com.app.xpertgroup.data.remote.api

import com.app.xpertgroup.data.remote.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    companion object {
        private const val USERS = "users"
    }

    @GET(USERS)
    fun getUsers(): Call<List<UserResponse>>
}