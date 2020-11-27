package com.example.quotesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.databinding.QuotesListItemBinding
import com.example.quotesapp.databinding.TagsListItemBinding
import com.example.quotesapp.view.adapter.viewHolder.QuotesListViewHodler
import com.example.quotesapp.view.adapter.viewHolder.TagsListViewHolder
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.TagsListViewModel

class TagsListAdapter (private val TagsListViewModel: TagsListViewModel,
                       private val activity: FragmentActivity?) :
    RecyclerView.Adapter<TagsListViewHolder>() {
    var tagsList: List<Tags> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = TagsListItemBinding.inflate(inflater, parent, false)
        val context = parent.context
        return TagsListViewHolder(dataBinding, TagsListViewModel, activity)
    }

    override fun getItemCount() = tagsList.size

    override fun onBindViewHolder(holder: TagsListViewHolder, position: Int) {
        holder.setup(tagsList[position])

    }

    fun updateTagsList(tagsList: List<Tags>) {
        this.tagsList = tagsList
        notifyDataSetChanged()
    }
}