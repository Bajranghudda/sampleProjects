package com.example.sadidotcom.data.model.api

import com.example.sadidotcom.data.model.PersonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/")
    suspend fun getItems(@Query("results") pageSize: Int = 10): Response<PersonModel>
}