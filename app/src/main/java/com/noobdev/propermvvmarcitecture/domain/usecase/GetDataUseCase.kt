package com.noobdev.propermvvmarcitecture.domain.usecase

import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse
import com.noobdev.propermvvmarcitecture.repo.Repository
import io.reactivex.Single
import javax.inject.Inject

/**
 * We can call only one method
 * */
class GetDataUseCase  @Inject
    constructor(val apiRepo: Repository)  {
    suspend operator fun invoke():DomainParsableResponse{
       return apiRepo.getDataRepo(20,0)
    }

}