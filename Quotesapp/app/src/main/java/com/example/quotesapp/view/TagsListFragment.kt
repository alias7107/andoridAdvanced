package com.example.quotesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotesapp.databinding.QuotesListFragmentBinding
import com.example.quotesapp.databinding.TagsListFragmentBinding
import com.example.quotesapp.view.adapter.QuotesListAdapter
import com.example.quotesapp.view.adapter.TagsListAdapter
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.TagsListViewModel
import kotlinx.android.synthetic.main.quotes_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.tags_list_fragment.*

class TagsListFragment: Fragment(){
    private lateinit var viewDataBinding: TagsListFragmentBinding
    private lateinit var adapter: TagsListAdapter
    private val TagsListViewModel: TagsListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = TagsListFragmentBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(viewLifecycleOwner)
        }
        viewDataBinding.tagsViewModel = TagsListViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.tagsViewModel?.fetchTagsList()
        setupAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.tagsViewModel?.fetchTagsList()?.observe(viewLifecycleOwner, Observer {
            adapter.updateTagsList(it)


        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.tagsViewModel
        if (viewModel != null) {
            adapter = TagsListAdapter(viewDataBinding.tagsViewModel!!, activity)
            val layoutManager = GridLayoutManager(activity,2)
            tags_list_rv.layoutManager = layoutManager
            tags_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            tags_list_rv.adapter = adapter
        }
    }
}
