package com.noobdev.propermvvmarcitecture.network.model

import com.noobdev.propermvvmarcitecture.domain.model.DataItem
import com.noobdev.propermvvmarcitecture.domain.model.DomainParsableResponse
import com.noobdev.propermvvmarcitecture.domain.utils.DomainMapper

class ResponseDtoMapper : DomainMapper<ResponseDto, DomainParsableResponse> {
    override fun mapToDomainModel(entity: ResponseDto): DomainParsableResponse {
        return DomainParsableResponse(
            timestamp = entity.timestamp,
            data = entity.data?.let { mapFromEntityList(it) }
        )
    }

    override fun mapFromDomainModel(domainModel: DomainParsableResponse): ResponseDto {
        return ResponseDto(
            timestamp = domainModel.timestamp,
            data = domainModel.data?.let { mapToEntityList(it) }
        )
    }

    private fun mapFromEntityList(input: List<SerializedDataItem>): List<DataItem> {
        val output: MutableList<DataItem> = mutableListOf()
        input.forEach { item ->
            output.add(
                DataItem(
                    symbol = item.symbol,
                    volumeUsd24Hr = item.volumeUsd24Hr,
                    marketCapUsd = item.marketCapUsd,
                    priceUsd = item.priceUsd,
                    vwap24Hr = item.vwap24Hr,
                    changePercent24Hr = item.changePercent24Hr,
                    name = item.name,
                    explorer = item.explorer,
                    rank = item.rank,
                    id = item.id,
                    maxSupply = item.maxSupply,
                    supply = item.supply
                )
            )
        }

        return output.toList()
//         return DataItem(
//            symbol = initial.symbol,
//            volumeUsd24Hr = entity.volumeUsd24Hr,
//            marketCapUsd = entity.marketCapUsd,
//            priceUsd = entity.priceUsd,
//            vwap24Hr = entity.vwap24Hr,
//            changePercent24Hr = entity.changePercent24Hr,
//            name = entity.name,
//            explorer = entity.explorer,
//            rank = entity.rank,
//            id = entity.id,
//            maxSupply = entity.maxSupply,
//            supply = entity.supply
//        )
    }

    private fun mapToEntityList(input: List<DataItem>): List<SerializedDataItem> {
        val output: MutableList<SerializedDataItem> = mutableListOf()
        input.forEach { dataItem ->
            output.add(
                SerializedDataItem(
                    symbol = dataItem.symbol,
                    volumeUsd24Hr = dataItem.volumeUsd24Hr,
                    marketCapUsd = dataItem.marketCapUsd,
                    priceUsd = dataItem.priceUsd,
                    vwap24Hr = dataItem.vwap24Hr,
                    changePercent24Hr = dataItem.changePercent24Hr,
                    name = dataItem.name,
                    explorer = dataItem.explorer,
                    rank = dataItem.rank,
                    id = dataItem.id,
                    maxSupply = dataItem.maxSupply,
                    supply = dataItem.supply,
                )
            )
        }
//        return iterator.map { mapToEntity(it).data }
        return output.toList()
    }
}



