package com.abhijeet.samplemvvm.core.di

import android.content.Context
import com.abhijeet.samplemvvm.network.retrofit.RetrofitDataRepository
import com.abhijeet.samplemvvm.network.volley.VolleyDataRepository
import com.abhijeet.samplemvvm.view.MainActivity
import com.abhijeet.samplemvvm.viewmodel.MyViewModelFactory
import com.android.volley.RequestQueue
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DependencyModule::class])
interface DependencyGraph {

    fun getRetrofitRepository(): RetrofitDataRepository

    //fun volleyDataRepository(volleyRequestQueue: RequestQueue): VolleyDataRepository
    fun inject(activity: MainActivity)
}