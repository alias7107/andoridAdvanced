package com.example.quotesapp.view.adapter.viewHolder

import android.util.Log
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.view.*
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.TagsListViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

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

            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.tagsListFragment, fragment)?.commit()


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