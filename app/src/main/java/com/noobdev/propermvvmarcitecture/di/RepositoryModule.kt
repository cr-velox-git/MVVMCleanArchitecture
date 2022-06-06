package com.noobdev.propermvvmarcitecture.di

import com.noobdev.propermvvmarcitecture.data.ApiService
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.repo.Repository
import com.noobdev.propermvvmarcitecture.repo.Repository_Impl
import com.noobdev.propermvvmarcitecture.repo.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

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