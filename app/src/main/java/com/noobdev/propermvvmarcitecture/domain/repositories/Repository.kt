package com.noobdev.propermvvmarcitecture.domain.repositories

import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.utils.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {
    /**it is in the Repository_Impl
     * [Flow] is a coroutine function that returns multiple value over period of time to same object
     * */
    suspend fun getFromRepository(
        limit: Int,
        offset: Int
    ): Flow<Resource<DomainResponse>>
    //other fun domain (buisness model)
}