package com.noobdev.propermvvmarcitecture.repo
import com.noobdev.propermvvmarcitecture.data.ApiService
import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse
import com.noobdev.propermvvmarcitecture.network.model.ResponseDto
import com.noobdev.propermvvmarcitecture.network.model.ResponseDtoMapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ResponseDtoMapper,
) : Repository{

    override suspend fun getDataRepo(limit: Int, offset: Int): DomainParsableResponse {
        val  result = apiService.getData(0,0)
        return mapper.mapToDomainModel(result)
    }
}