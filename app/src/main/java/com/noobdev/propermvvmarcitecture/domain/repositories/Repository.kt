package com.noobdev.propermvvmarcitecture.domain.repositories

import com.noobdev.propermvvmarcitecture.domain.model.DomainResponse
import com.noobdev.propermvvmarcitecture.utils.Resource


interface Repository {
        /**it is in the Repoitory_Impl*/
        suspend fun get(limit: Int, offset: Int): Resource<DomainResponse>
        //other fun domain (buisness model)
}