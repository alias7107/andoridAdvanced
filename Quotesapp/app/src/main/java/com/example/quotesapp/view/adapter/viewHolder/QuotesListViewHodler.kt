package com.example.quotesapp.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.view.QuoteDetailFragment
import com.example.quotesapp.view.SearchableQuotesListFragment
import com.example.quotesapp.view.TagsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.quotes_list_item.view.*


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
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, fragment)?.addToBackStack(null)?.commit()

        }

        if(itemData.favourite){
            itemView.iv_like.setImageResource(R.drawable.ic_licked)
        }


        itemView.iv_like.setOnClickListener {
            QuotesListViewModel.favQuote(itemData.id)
            itemView.iv_like.setBackgroundResource(R.drawable.ic_licked)
        }


//        itemView.setOnClickListener{
//
//            val service = MovieDetailFragment(itemData)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.commit()
//
//        }
    }

}