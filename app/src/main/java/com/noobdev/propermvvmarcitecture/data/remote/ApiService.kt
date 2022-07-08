package com.noobdev.propermvvmarcitecture.data.remote

import com.noobdev.propermvvmarcitecture.data.remote.dto.ResponseDto
import com.noobdev.propermvvmarcitecture.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    /*  @GET("/v2/assets")
      suspend fun getData(
          @Query("limit") limit: Int,
          @Query("offset") offset: Int): ResponseDto
  */

    @GET("/v2/assets")
    suspend fun getDataFromApiService(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): ResponseDto

}