package com.example.baitaptuan4_th02

import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Path

interface ApiService {
    @GET("tasks")
    suspend fun getTask(): ApiResponse<List<TaskData>>
    @GET("task/{id}")
    suspend fun getTaskById(@Path("id") id: Int):  ApiResponse<TaskData>
}