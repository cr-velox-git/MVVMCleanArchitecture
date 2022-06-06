package com.noobdev.propermvvmarcitecture.repo

import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse
import com.noobdev.propermvvmarcitecture.network.model.ResponseDto

interface Repository {
        suspend fun getDataRepo(limit: Int, offset: Int): ResponseDto
        //other fun domain (buisness model)
}
