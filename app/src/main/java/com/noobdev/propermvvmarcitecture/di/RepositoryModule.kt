package com.noobdev.propermvvmarcitecture.di

import com.noobdev.propermvvmarcitecture.network.ApiService
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.repositories.Repository
import com.noobdev.propermvvmarcitecture.repositories.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideResponseRepository(
        apiService: ApiService,
        responseDtoMapper: ResponseDtoMapper
    ): Repository {
        return RepositoryImpl(
            apiService = apiService,
            mapper = responseDtoMapper
        )
    }
}