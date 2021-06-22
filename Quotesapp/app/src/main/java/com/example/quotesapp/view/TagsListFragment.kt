package com.example.quotesapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.quotesapp.databinding.TagsListFragmentBinding
import com.example.quotesapp.view.adapter.TagsListAdapter
import com.example.quotesapp.viewModel.TagsListViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quotesapp.data.model.Tags
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
        shimmerLayout.startShimmerAnimation()
        setupAdapter()
        setObservers()
    }


    private fun setObservers() {
        viewDataBinding.tagsViewModel?.getTagsList()?.observe(viewLifecycleOwner, Observer {
            adapter.updateTagsList(it)
            shimmerLayout.stopShimmerAnimation()
            shimmerLayout.visibility = View.GONE })
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
//        view?.findNavController()?.navigate(TagsListFragmentDirections)
        tags_list_rv.setHasFixedSize(true)
        tags_list_rv.setItemViewCacheSize(20)
    }

}
