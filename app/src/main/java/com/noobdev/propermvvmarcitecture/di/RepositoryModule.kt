package com.noobdev.propermvvmarcitecture.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
//    @Singleton
//    @Provides
//    fun provideResponseRepository(
//        apiService: ApiService,
//        responseDtoMapper: ResponseDtoMapper
//    ):Repository {
//return Repository_Impl(apiService,responseDtoMapper)
//    }
}