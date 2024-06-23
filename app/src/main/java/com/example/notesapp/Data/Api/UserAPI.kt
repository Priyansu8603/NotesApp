package com.example.notesapp.Data.Api

import com.example.notesapp.Data.Model.UserRequest
import com.example.notesapp.Data.Model.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/users/signup")
    suspend fun signup(@Body userRequest: UserRequest): Response<UserResponse>

    @POST("/users/signin")
    fun signin(@Body userRequest:UserRequest):Response<UserResponse>


}