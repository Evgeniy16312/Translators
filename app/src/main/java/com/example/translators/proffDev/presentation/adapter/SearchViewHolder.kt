package com.example.translators.proffDev.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.translators.databinding.FragmentSearchListItemBinding
import com.example.translators.proffDev.domain.model.search.DataModel

class SearchViewHolder(
    private val binding: FragmentSearchListItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(dataModel: DataModel, listener: (dataModel: DataModel) -> Unit) {
        binding.titleTextView.text = dataModel.text
        binding.translationTextView.text = dataModel.meanings[0].translation.text
        binding.root.setOnClickListener {
            listener(dataModel)
        }
    }
}