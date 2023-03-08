package com.abhijeet.samplemvvm.network.volley

import com.abhijeet.samplemvvm.model.MeowFacts
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import org.json.JSONArray
import javax.inject.Inject

class VolleyDataRepository @Inject constructor (private val requestQueue: RequestQueue) {

    companion object {
        private const val url: String = "https://meowfacts.herokuapp.com/?count=10"
    }

    fun getMeowFacts(callback: (List<MeowFacts>) -> Unit) {
        val jsonRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            { response ->
                if (response?.get("data") != null) {
                    val list = mutableListOf<MeowFacts>()
                    val array: JSONArray = response.get("data") as JSONArray
                    for (index in 0 until array.length()) {
                        list.add(MeowFacts(array[index] as String))
                    }
                    println("response***************${list.size}")
                    callback.invoke(list)
                }
            },
            { error ->
                println(error)
            }
        )
        requestQueue.add(jsonRequest)
    }
}