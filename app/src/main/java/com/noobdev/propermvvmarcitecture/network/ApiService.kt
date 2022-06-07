package com.noobdev.propermvvmarcitecture.network

import com.noobdev.propermvvmarcitecture.network.model.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v2")
    suspend fun getData(@Query("limit") limit: Int, @Query("offset") offset: Int): ResponseDto

}