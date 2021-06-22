package com.example.quotesapp.view.adapter.viewHolder.QuoteListViewHolder


import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.view.*


class QuotesListViewHodler constructor(
    dataBinding: ViewDataBinding,
    private val quotesListViewModel: QuotesListViewModel,
    activity: FragmentActivity?
) : BaseViewHolder(dataBinding, quotesListViewModel, activity) {

    override fun navigate(view: View, itemData:Item) {

            view.findNavController().navigate(QuotesListFragmentDirections.actionQuotesListFragmentToQuoteDetailFragment(itemData.id))
    }

}