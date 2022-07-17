package com.noobdev.propermvvmarcitecture.data.repositories

import com.noobdev.propermvvmarcitecture.data.remote.ApiService
import com.noobdev.propermvvmarcitecture.data.remote.dto.ResponseDtoMapper
import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.domain.repositories.Repository
import com.noobdev.propermvvmarcitecture.utils.Resource
import com.noobdev.propermvvmarcitecture.utils.UiErrorText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ResponseDtoMapper,
) : Repository {
    /*
    override suspend fun get(limit: Int, offset: Int): Resource<DomainResponse> {
        //ask for error and status
        return try {
            val response = apiService.getData(20, 0)

            Resource.Success(mapper.mapToDomainModel(response))
        } catch (e: IOException) {
            Resource.Error(UiErrorText.DynamicString(e.message.toString()))
        } catch (e: HttpException) {
            Resource.Error(UiErrorText.DynamicString(e.message.toString()))
        }
    }
*/
    /*  override suspend fun get(limit: Int, offset: Int): DomainResponse {
          try {
              val response = apiService.getData(20, 0)
              return mapper.mapToDomainModel(response)

          } catch (throwable: Throwable) {
              when (throwable) {
                  is IOException -> processingError()
                  is HttpException -> {
                      connectionError(throwable.message())
                  }
                  else -> {
                      processingError()
                  }
              }
              return mapper.mapToDomainModel(ResponseDto())
          }
      }*/
    override suspend fun getFromRepository(
        limit: Int,
        offset: Int
    ): Flow<Resource<DomainResponse>> {
        return flow {
            emit(Resource.Loading(true))
            //val response = apiService.getDataFromApiService(20, 0)
            try {
                val response = apiService.getDataFromApiService(limit, offset)
                emit(Resource.Success(mapper.mapToDomainModel(response)))
            } catch (e: IOException) {
                emit(Resource.Error(UiErrorText.DynamicString(e.message.toString())))
            } catch (e: HttpException) {
                emit(Resource.Error(UiErrorText.DynamicString(e.message.toString())))
            }
            emit(Resource.Loading(false))
        }
    }
}