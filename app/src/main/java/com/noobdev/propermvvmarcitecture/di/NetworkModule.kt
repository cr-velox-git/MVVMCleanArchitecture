package com.noobdev.propermvvmarcitecture.di

import android.app.Application
import com.noobdev.propermvvmarcitecture.data.ApiService
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.repo.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.internal.managers.ApplicationComponentManager
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideResponseMapper():ResponseDtoMapper{
        return ResponseDtoMapper()
    }

    @Singleton
    @Provides
    fun provideResponseService():ApiService{
        return  Retrofit.Builder()
            .baseUrl("https://api.coincap.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}
