package com.abhijeet.samplemvvm.core.di

import android.content.Context
import com.abhijeet.samplemvvm.network.volley.RequestQueueProvider
import com.android.volley.RequestQueue
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

// if the object creation is complex (cannot be done through @inject) then use module
// Here we are creating an object of a third party library i.e. RequestQueue

@Module
class DependencyModule(private val context: Context) {

    // This isn't implemented yet, there were issues injecting RequestQueueProvider
    @Provides
    @Singleton
    fun getVolleyRepository(): RequestQueueProvider {
        return RequestQueueProvider.getInstance(context)
    }
}