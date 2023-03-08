package com.abhijeet.samplemvvm.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.samplemvvm.R
import com.abhijeet.samplemvvm.viewmodel.MyViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private val mAdapter by lazy {
        com.abhijeet.samplemvvm.view.ListAdapter()
    }
    private lateinit var progressBar: ProgressBar
    private lateinit var recyclerView: RecyclerView

    private val viewModel: MyViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(
            context,
            RecyclerView.VERTICAL,
            false
        )
        progressBar = view.findViewById<ProgressBar>(R.id.progress_bar)
        recyclerView.adapter = mAdapter
        observe()
        getData()
    }

    private fun observe() {
        viewModel.list.observe(viewLifecycleOwner, Observer { list ->
            if (list.isNotEmpty()) {
                progressBar.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                mAdapter.addItems(list)
                mAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun getData() {
        //viewModel.getData()
        viewModel.getDataByRetrofit()
    }
}