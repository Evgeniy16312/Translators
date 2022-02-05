package com.example.translators.proffDev.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.translators.databinding.FragmentSearchListItemBinding
import com.example.translators.proffDev.domain.model.search.DataModel

class SearchAdapter(
    private var data: List<DataModel> = emptyList(),
    private val listener: (dataModel: DataModel) -> Unit
) : RecyclerView.Adapter<SearchViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<DataModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder =
        SearchViewHolder(
            FragmentSearchListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) =
        holder.bind(data[position], listener)

    override fun getItemCount(): Int = data.size

}