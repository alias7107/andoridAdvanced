package com.example.quotesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.view.adapter.viewHolder.QuotesListViewHodler
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.databinding.QuotesListItemBinding



class QuotesListAdapter  (private val QuotesListViewModel: QuotesListViewModel,
                          private val activity: FragmentActivity?) :
    RecyclerView.Adapter<QuotesListViewHodler>() {
    var quotesList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesListViewHodler {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = QuotesListItemBinding.inflate(inflater, parent, false)
        val context = parent.context
        return QuotesListViewHodler(dataBinding, QuotesListViewModel, activity)
    }

    override fun getItemCount() = quotesList.size

    override fun onBindViewHolder(holder: QuotesListViewHodler, position: Int) {

        holder.setup(quotesList[position])

    }

    fun updateQuoteList(quotesList: List<Item>) {
        this.quotesList = quotesList
        notifyDataSetChanged()
    }
}