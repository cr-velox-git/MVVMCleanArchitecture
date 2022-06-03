package com.noobdev.propermvvmarcitecture.domain.utils

interface DomainMapper <T, DomainModel>{
    fun mapToDomainModel(entity: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel):T
}
