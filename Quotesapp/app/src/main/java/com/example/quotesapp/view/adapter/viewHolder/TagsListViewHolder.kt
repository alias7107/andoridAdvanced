package com.example.quotesapp.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.view.QuoteDetailFragment
import com.example.quotesapp.view.QuotesListFragment
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.TagsListViewModel

class TagsListViewHolder constructor(
    val dataBinding: ViewDataBinding,
    private val tagsListViewModel: TagsListViewModel,
    val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(tagsData: Tags) {
        dataBinding.setVariable(BR.tagData, tagsData)
        dataBinding.executePendingBindings()
        itemView.setOnClickListener{

            val fragment = QuotesListFragment(tagsData)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.addToBackStack(null)?.commit()

        }

    }

    //        itemView.setOnClickListener{
//
//            val fragment = MovieDetailFragment(tagData)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.tags_fragment
//            , fragment)?.commit()
//
//        }
}