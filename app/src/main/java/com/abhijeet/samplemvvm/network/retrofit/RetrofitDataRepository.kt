package com.abhijeet.samplemvvm.network.retrofit

import com.abhijeet.samplemvvm.model.MeowFacts
import javax.inject.Inject

class RetrofitDataRepository @Inject constructor() {

    private val service: ApiService = RetrofitClient.getInstance().create(ApiService::class.java)

    internal suspend fun getMeowFacts(): List<MeowFacts> {
        val response = service.getMeowFacts().data
        val list = mutableListOf<MeowFacts>()
        for (facts in response) {
            list.add(MeowFacts(facts))
        }
        return list
    }

}

