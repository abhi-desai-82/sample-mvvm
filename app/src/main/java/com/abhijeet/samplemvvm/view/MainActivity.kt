package com.abhijeet.samplemvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.abhijeet.samplemvvm.R
import com.abhijeet.samplemvvm.core.MyApplication
import com.abhijeet.samplemvvm.core.di.DependencyGraph
import com.abhijeet.samplemvvm.viewmodel.MyViewModel
import com.abhijeet.samplemvvm.viewmodel.MyViewModelFactory

// https://meowfacts.herokuapp.com/?count=10

class MainActivity : AppCompatActivity() {

    private val di: DependencyGraph by lazy {
        (applicationContext as MyApplication).dependencyGraph
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        // inject the activity
        di.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize a viewmodel
        //ViewModelProvider(this, MyViewModelFactory(this))[MyViewModel::class.java]
        ViewModelProvider(this, MyViewModelFactory(this, di))[MyViewModel::class.java]

        // add fragment
        supportFragmentManager.commit {
            add(R.id.fragment_container_view, MainFragment())
        }
    }
}