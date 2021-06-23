package com.example.quotesapp.view.adapter.viewHolder

import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.BR
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.view.*

class TagsListViewHolder constructor(
    val dataBinding: ViewDataBinding,
    val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {

    fun setup(tagsData: Tags) {
        dataBinding.setVariable(BR.tagData, tagsData)
        dataBinding.executePendingBindings()

        itemView.setOnClickListener {
            it.findNavController().navigate(TagsListFragmentDirections.actionTagsListFragmentToQuotesListFragment(tagsData.name))
        }
    }
}