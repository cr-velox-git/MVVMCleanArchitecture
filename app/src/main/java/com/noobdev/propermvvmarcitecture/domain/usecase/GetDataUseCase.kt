package com.noobdev.propermvvmarcitecture.domain.usecase

import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.domain.repositories.Repository
import com.noobdev.propermvvmarcitecture.utils.Resource
import com.noobdev.propermvvmarcitecture.utils.UiErrorText
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * We should call only one method (recommended) with in a single class.
 * UseCase connects the viewmodel to the repositoryModule in di
 * */
class GetDataUseCase @Inject
constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(limit: Int, offset: Int): Flow<Resource<DomainResponse>> {
        if (limit == 0 || offset == 0) {
            return flow {
                emit(Resource.Error(UiErrorText.StringResource(R.string.empty)))
            }
        }
        return repository.getFromRepository(limit, offset)
    }
}