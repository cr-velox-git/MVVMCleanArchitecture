package com.noobdev.propermvvmarcitecture.di_dependency_injection

import com.noobdev.propermvvmarcitecture.data.remote.ApiService
import com.noobdev.propermvvmarcitecture.data.remote.dto.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.domain.repositories.Repository
import com.noobdev.propermvvmarcitecture.data.repositories.RepositoryImpl
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