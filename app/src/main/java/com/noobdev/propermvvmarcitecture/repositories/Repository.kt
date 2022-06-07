package com.noobdev.propermvvmarcitecture.repositories

import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse


interface Repository {
        /**it is in the Repoitory_Impl*/
        suspend fun get(limit: Int, offset: Int): DomainResponse
        //other fun domain (buisness model)
}