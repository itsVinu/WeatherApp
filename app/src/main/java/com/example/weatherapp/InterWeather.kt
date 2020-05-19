package com.example.weatherapp

import com.example.weatherapp.days16response.Next16DaysResponse
import com.example.weatherapp.weatherresponse.DailyWeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InterWeather {

    @GET("weather?appid=7bbeec176cbdcfbdce3b81e0b6cc14b7&units=Metric")
    suspend fun getCurrentWeather(@Query("q")q:String ): Response<DailyWeatherResponse>

//    @GET("hourly?key=79b7eaf372cf4785964df45cd3f17c12&hours=24")
//    suspend fun getWeatherBitRequest(@Query("city")city:String):Response<ForecastResponse>

    @GET("daily?key=79b7eaf372cf4785964df45cd3f17c12")
    suspend fun get16daysweather(@Query("city")city:String):Response<Next16DaysResponse>

}
