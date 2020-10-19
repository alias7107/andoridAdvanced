package com.example.quotesapp.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.view.QuoteDetailFragment


class QuotesListViewHodler constructor(
    val dataBinding: ViewDataBinding,
    private val QuotesListViewModel: QuotesListViewModel,
    val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()
        itemView.setOnClickListener{

            val fragment = QuoteDetailFragment(itemData)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.commit()

        }

//
//        itemView.setOnClickListener{
//
//            val fragment = MovieDetailFragment(itemData)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.commit()
//
//        }
    }

}