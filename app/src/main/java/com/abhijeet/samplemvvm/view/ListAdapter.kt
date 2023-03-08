package com.abhijeet.samplemvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.abhijeet.samplemvvm.R
import com.abhijeet.samplemvvm.model.MeowFacts

class ListAdapter() : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private var list = emptyList<MeowFacts>()

    class ViewHolder(private val item: View) : RecyclerView.ViewHolder(item) {
        fun bind(text: MeowFacts) {
            item.findViewById<TextView>(R.id.text).text = text.facts
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(
            parent.context
        ).inflate(
            R.layout.list_item,
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size ?: 0

    fun addItems(list: List<MeowFacts>) {
        this.list = list
    }
}