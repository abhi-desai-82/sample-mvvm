package com.abhijeet.samplemvvm

import com.abhijeet.samplemvvm.model.MeowFacts
import com.abhijeet.samplemvvm.network.retrofit.RetrofitDataRepository
import com.abhijeet.samplemvvm.network.volley.VolleyDataRepository
import com.abhijeet.samplemvvm.viewmodel.MyViewModel
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import junit.framework.Assert.assertNotNull
import org.junit.Test

class MyViewModelTest {

    @Test
    fun `Test getData() when mutable list is null`() {
        val mockCallback: (List<MeowFacts>) -> Unit = mockk(relaxed = true) {

        }

        val mockRepositoryVolley: VolleyDataRepository = mockk(relaxed = true) {
            every { getMeowFacts(mockCallback) } just runs
        }
        val subject = MyViewModel(mockRepositoryVolley, RetrofitDataRepository())
        subject.getData()
        assertNotNull(subject.list)
    }

}