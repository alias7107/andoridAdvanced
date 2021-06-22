package com.example.quotesapp.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.BR
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.view.*
import com.example.quotesapp.viewModel.TagsListViewModel

class TagsListViewHolder constructor(

    val dataBinding: ViewDataBinding,
//    private val tagsListViewModel: TagsListViewModel,
    val activity: FragmentActivity?

) : RecyclerView.ViewHolder(dataBinding.root) {




    fun setup(tagsData: Tags) {

        dataBinding.setVariable(BR.tagData, tagsData)
        dataBinding.executePendingBindings()
//        val fragment = QuotesListFragment(tagsData)

        itemView.setOnClickListener {
            it.findNavController().navigate(TagsListFragmentDirections.actionTagsListFragmentToQuotesListFragment(tagsData.name))
//            Log.d("tagsData",tagsData.name)


        }
//
////            activity?.supportFragmentManager?.beginTransaction()?.add(R.id.tagsListFragment, fragment)?.addToBackStack(null)?.commit()
//
//
//        }


    }

    //        itemView.setOnClickListener{
//
//            val fragment = MovieDetailFragment(tagData)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.tags_fragment
//            , fragment)?.commit()
//
//        }
}