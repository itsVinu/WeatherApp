package com.example.weatherapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Client {

    val gson = GsonBuilder().create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.openweathermap.org/data/2.5/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api = retrofit.create(InterWeather::class.java)

    val retro1 = Retrofit.Builder()
        .baseUrl("https://api.weatherbit.io/v2.0/forecast/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retro2 = Retrofit.Builder()
        .baseUrl("https://restcountries.eu/rest/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val api2 = retro2.create(InterWeather::class.java)

    val api1 = retro1.create(InterWeather::class.java)

}