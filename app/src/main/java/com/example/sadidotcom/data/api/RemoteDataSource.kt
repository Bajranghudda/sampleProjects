package com.example.sadidotcom.data.model.api

import com.example.sadidotcom.data.api.BaseDataSource

class RemoteDataSource(private val apiService: ApiService) : BaseDataSource(){

    suspend fun getItems() = getResult {
        apiService.getItems()
    }
}