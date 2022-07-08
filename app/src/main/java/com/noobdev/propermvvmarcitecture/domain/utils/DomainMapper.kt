package com.noobdev.propermvvmarcitecture.domain.utils


/**
 * This [DomainMapper] connects the [Domain] to [DTO] or [Entity]
 * */
interface DomainMapper <T, DomainModel>{
    fun mapToDomainModel(entity: T): DomainModel
    fun mapFromDomainModel(domainModel: DomainModel):T
}
