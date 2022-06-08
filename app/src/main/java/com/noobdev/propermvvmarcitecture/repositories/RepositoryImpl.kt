package com.noobdev.propermvvmarcitecture.repositories
import com.noobdev.propermvvmarcitecture.network.ApiService
import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ResponseDtoMapper,
) : Repository{

    override suspend fun get(limit: Int, offset: Int): DomainResponse {
        val  result = apiService.getData(20,0)
        return mapper.mapToDomainModel(result)
    }
}