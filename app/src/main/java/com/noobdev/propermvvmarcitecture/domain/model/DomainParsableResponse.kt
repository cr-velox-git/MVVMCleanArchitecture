package com.noobdev.propermvvmarcitecture.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.time.Instant
import java.util.*

/**
 * This is domain will convert the data from api to as we need and specific the values function.
 * keep the value which are only need to the ui.
 * [SerializedName] it convert the data class(eg String) to byte stream and where we need it convert back to data class which is called [deserilization]
 * [Parcelable] both are simillar but it is effecient according to android platform
 * */

//delete the serialized and parciable

data class DomainParsableResponse(

	val data: List<DataItem>? = null,

	val timestamp: Date? = null
)


data class DataItem(
	val priceUsd: String? = null,
	val vwap24Hr: String? = null,
	val changePercent24Hr: String? = null,
	val name: String? = null,
	val id: String? = null,
)
