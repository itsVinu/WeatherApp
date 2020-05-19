package com.example.weatherapp.days16response

import com.google.gson.annotations.SerializedName

data class Weather(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("icon")
	val icon: String? = null,

	@field:SerializedName("description")
	val description: String? = null
)