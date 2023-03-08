package com.abhijeet.samplemvvm.network.volley

import android.content.Context
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import javax.inject.Inject

class RequestQueueProvider (private val context: Context) {

    companion object {
        private var INSTANCE: RequestQueueProvider? = null
        fun getInstance(context: Context): RequestQueueProvider =
            synchronized(this) {
                INSTANCE ?: RequestQueueProvider(context).also {
                    INSTANCE = it
                }
            }
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context.applicationContext)
    }

    /*fun <T> addToRequestQueue(request: Request<T>) {
        requestQueue.add(request)
    }*/
}