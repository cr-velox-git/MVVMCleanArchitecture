package com.noobdev.propermvvmarcitecture.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.time.Instant
import java.util.*

/**
 *
 * This is domain will convert the data from api to as we need and specific the values function.
 * keep the value which are only need to the ui.
 *
 * */

/**
 * [SerializedName] it convert the data class(eg String) to byte stream and where we need it convert back to data class which is called [deserilization]
 * [Parcelable] both are simillar but it is effecient according to android platform
 * */

//delete the serialized and parciable
@Parcelize
data class DomainParsableResponse(

	val data: List<DataItem>? = null,

	val timestamp: Date? = null
) : Parcelable

//

@Parcelize
data class DataItem(

	@field:SerializedName("symbol")
	val symbol: String? = null,


	@field:SerializedName("priceUsd")
	val priceUsd: String? = null,

	@field:SerializedName("vwap24Hr")
	val vwap24Hr: String? = null,

	@field:SerializedName("changePercent24Hr")
	val changePercent24Hr: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("explorer")
	val explorer: String? = null,

	@field:SerializedName("rank")
	val rank: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("maxSupply")
	val maxSupply: String? = null,

	@field:SerializedName("supply")
	val supply: String? = null
) : Parcelable
