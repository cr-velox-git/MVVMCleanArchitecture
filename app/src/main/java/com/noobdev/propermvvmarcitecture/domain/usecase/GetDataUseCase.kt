package com.noobdev.propermvvmarcitecture.domain.usecase

import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.repositories.Repository
import javax.inject.Inject

/**
 * We should call only one method (recommended)
 * */
class GetDataUseCase  @Inject
    constructor(val apiRepo: Repository)  {
    suspend operator fun invoke():DomainResponse{
       return apiRepo.get(20,0)
    }
}