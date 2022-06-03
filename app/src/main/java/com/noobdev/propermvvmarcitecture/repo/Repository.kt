package com.noobdev.propermvvmarcitecture.repo

import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse

class Repository {
    interface Repo {
        suspend fun getDataRepo(limit: Int, offset: Int): DomainParsableResponse

        //other fun domain (buisness model)
    }
}