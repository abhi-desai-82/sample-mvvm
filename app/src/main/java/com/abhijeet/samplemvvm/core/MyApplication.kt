package com.abhijeet.samplemvvm.core

import android.app.Application
import com.abhijeet.samplemvvm.core.di.DaggerDependencyGraph
import com.abhijeet.samplemvvm.core.di.DependencyGraph
import com.abhijeet.samplemvvm.core.di.DependencyModule

class MyApplication : Application() {
    val dependencyGraph: DependencyGraph by lazy {
        DaggerDependencyGraph.create()
    }
}