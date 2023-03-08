package com.abhijeet.samplemvvm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhijeet.samplemvvm.core.di.DependencyGraph
import com.abhijeet.samplemvvm.network.volley.VolleyDataRepository
import com.abhijeet.samplemvvm.network.volley.RequestQueueProvider
import javax.inject.Inject

internal class MyViewModelFactory(private val context: Context, private val di: DependencyGraph) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(
                VolleyDataRepository(
                    RequestQueueProvider.getInstance(context).requestQueue
                ),
                di.getRetrofitRepository()
            ) as T
        }
        throwException()
    }

    private fun throwException(): Nothing {
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}