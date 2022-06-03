package com.noobdev.propermvvmarcitecture.repo

import com.noobdev.propermvvmarcitecture.network.model.ResponseNetworkEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2")
    suspend fun getData(@Query("limit") limit: Int, @Query("offset") offset: Int): ResponseNetworkEntity

}