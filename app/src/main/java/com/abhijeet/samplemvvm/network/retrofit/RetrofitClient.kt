package com.abhijeet.samplemvvm.network.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object RetrofitClient {

    fun getInstance(): Retrofit = Retrofit.Builder()
        .baseUrl("https://meowfacts.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}