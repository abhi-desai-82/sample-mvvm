package com.abhijeet.samplemvvm

import android.content.Context
import com.abhijeet.samplemvvm.network.volley.RequestQueueProvider
import com.abhijeet.samplemvvm.viewmodel.MyViewModel
import com.abhijeet.samplemvvm.viewmodel.MyViewModelFactory
import io.mockk.*
import org.junit.Test

class MyViewModelFactoryTest {

    @Test
    fun `verify create view model with valid ViewModel class`() {
        val mockkContext: Context = mockk(relaxed = true)
        val subject = MyViewModelFactory(mockkContext, di)
        val mockkRequestQueueProvider: RequestQueueProvider = mockk(relaxed = true) {
            //when(requestQueue) answer
        }
        every { RequestQueueProvider.getInstance(mockkContext) } returns mockkRequestQueueProvider
        mockkStatic(RequestQueueProvider::class)
        val response = subject.create(MyViewModel::class.java)
        response is MyViewModel
    }
}