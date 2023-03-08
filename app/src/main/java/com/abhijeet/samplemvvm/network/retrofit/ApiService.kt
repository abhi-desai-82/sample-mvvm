package com.abhijeet.samplemvvm.network.retrofit

import com.abhijeet.samplemvvm.model.MeowFacts
import com.abhijeet.samplemvvm.model.RetrofitMeowFacts
import retrofit2.http.GET

internal interface ApiService {

    @GET("?count=10")
    suspend fun getMeowFacts(): RetrofitMeowFacts
}