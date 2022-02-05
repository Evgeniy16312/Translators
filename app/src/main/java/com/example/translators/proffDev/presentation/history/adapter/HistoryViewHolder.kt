package com.example.translators.proffDev.presentation.history.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.translators.databinding.FragmentHistoryListItemBinding
import com.example.translators.proffDev.domain.model.history.History
import com.example.translators.proffDev.util.TimestampFormatter

class HistoryViewHolder(
    private val binding: FragmentHistoryListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(history: History) {
        binding.wordTextView.text = history.word
        binding.timestampTextView.text =
            TimestampFormatter.formatTimestampToHistoryString(history.timestamp)
    }
}
