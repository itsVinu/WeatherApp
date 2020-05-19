package com.example.weatherapp.days16response

import com.google.gson.annotations.SerializedName

data class Next16DaysResponse(

	@field:SerializedName("country_code")
	val countryCode: String? = null,

	@field:SerializedName("city_name")
	val cityName: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("lon")
	val lon: String? = null,

	@field:SerializedName("state_code")
	val stateCode: String? = null,

	@field:SerializedName("lat")
	val lat: String? = null
)