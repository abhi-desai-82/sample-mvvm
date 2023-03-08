package com.abhijeet.samplemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abhijeet.samplemvvm.model.MeowFacts
import com.abhijeet.samplemvvm.network.retrofit.RetrofitDataRepository
import com.abhijeet.samplemvvm.network.volley.VolleyDataRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

internal class MyViewModel(
    private val repositoryVolley: VolleyDataRepository,
    private val repositoryRetrofit: RetrofitDataRepository
) : ViewModel() {

    private val _list = MutableLiveData<List<MeowFacts>>()
    val list: LiveData<List<MeowFacts>> get() = _list

    // volley example
    fun getData() {
        if (_list.value.isNullOrEmpty()) {
            repositoryVolley.getMeowFacts {
                _list.value = it
            }
        }
    }

    // retrofit example
    fun getDataByRetrofit() {
        if (_list.value.isNullOrEmpty()) {
            GlobalScope.launch(Dispatchers.IO) {
                _list.postValue(repositoryRetrofit.getMeowFacts())
            }
        }
    }
}