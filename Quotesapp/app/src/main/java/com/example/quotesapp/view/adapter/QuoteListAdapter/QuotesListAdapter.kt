package com.example.quotesapp.view.adapter.QuoteListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import com.example.quotesapp.databinding.QuotesListItemBinding
import com.example.quotesapp.view.adapter.viewHolder.QuoteListViewHolder.QuotesListViewHodler
import com.example.quotesapp.viewModel.QuotesListViewModel


class QuotesListAdapter  (private val QuotesListViewModel: QuotesListViewModel,
                          private val activity: FragmentActivity?
) : BaseAdapter() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesListViewHodler {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = QuotesListItemBinding.inflate(inflater, parent, false)
        return QuotesListViewHodler(dataBinding, QuotesListViewModel, activity)
    }
}