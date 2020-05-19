package com.example.weatherapp.days16response

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("pres")
	val pres: Double? = null,

	@field:SerializedName("moon_phase")
	val moonPhase: Double? = null,

	@field:SerializedName("wind_cdir")
	val windCdir: String? = null,

	@field:SerializedName("moonrise_ts")
	val moonriseTs: Int? = null,

	@field:SerializedName("clouds")
	val clouds: Int? = null,

	@field:SerializedName("low_temp")
	val lowTemp: Double? = null,

	@field:SerializedName("wind_spd")
	val windSpd: Double? = null,

	@field:SerializedName("ozone")
	val ozone: Double? = null,

	@field:SerializedName("pop")
	val pop: Int? = null,

	@field:SerializedName("valid_date")
	val validDate: String? = null,

	@field:SerializedName("datetime")
	val datetime: String? = null,

	@field:SerializedName("precip")
	val precip: Double? = null,

	@field:SerializedName("sunrise_ts")
	val sunriseTs: Int? = null,

	@field:SerializedName("min_temp")
	val minTemp: Double? = null,

	@field:SerializedName("weather")
	val weather: Weather? = null,

	@field:SerializedName("app_max_temp")
	val appMaxTemp: Double? = null,

	@field:SerializedName("max_temp")
	val maxTemp: Double? = null,

	@field:SerializedName("snow_depth")
	val snowDepth: Int? = null,

	@field:SerializedName("sunset_ts")
	val sunsetTs: Int? = null,

	@field:SerializedName("max_dhi")
	val maxDhi: Any? = null,

	@field:SerializedName("clouds_mid")
	val cloudsMid: Int? = null,

	@field:SerializedName("vis")
	val vis: Double? = null,

	@field:SerializedName("uv")
	val uv: Double? = null,

	@field:SerializedName("high_temp")
	val highTemp: Double? = null,

	@field:SerializedName("temp")
	val temp: Double? = null,

	@field:SerializedName("clouds_hi")
	val cloudsHi: Int? = null,

	@field:SerializedName("app_min_temp")
	val appMinTemp: Double? = null,

	@field:SerializedName("moon_phase_lunation")
	val moonPhaseLunation: Double? = null,

	@field:SerializedName("dewpt")
	val dewpt: Double? = null,

	@field:SerializedName("wind_dir")
	val windDir: Double? = null,

	@field:SerializedName("wind_gust_spd")
	val windGustSpd: Double? = null,

	@field:SerializedName("clouds_low")
	val cloudsLow: Int? = null,

	@field:SerializedName("rh")
	val rh: Int? = null,

	@field:SerializedName("slp")
	val slp: Double? = null,

	@field:SerializedName("snow")
	val snow: Int? = null,

	@field:SerializedName("wind_cdir_full")
	val windCdirFull: String? = null,

	@field:SerializedName("moonset_ts")
	val moonsetTs: Int? = null,

	@field:SerializedName("ts")
	val ts: Int? = null
)