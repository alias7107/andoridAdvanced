package com.example.quotesapp.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotesapp.databinding.FragmentMyQuotesBinding
import com.example.quotesapp.view.adapter.QuoteListAdapter.QuotesListAdapter
import com.example.quotesapp.viewModel.QuotesListViewModel
import kotlinx.android.synthetic.main.quotes_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel


class myQuotes : Fragment() {
    private lateinit var viewDataBinding: FragmentMyQuotesBinding
    private lateinit var adapter: QuotesListAdapter
    private val QuotesListViewModel: QuotesListViewModel by viewModel()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var username: String



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = FragmentMyQuotesBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(viewLifecycleOwner)
        }
        viewDataBinding.myQuotesViewModel = QuotesListViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = context?.getSharedPreferences("Login", Context.MODE_PRIVATE)!!
        username = sharedPreferences.getString("username", null)!!
        viewDataBinding.myQuotesViewModel?.myQuotes(username)
        setupAdapter()

        setObservers()




    }

    private fun setObservers() {
        viewDataBinding.myQuotesViewModel?.myQuotes(username)?.observe(viewLifecycleOwner, Observer {
            adapter.updateQuoteList(it)


        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.myQuotesViewModel
        if (viewModel != null) {
            adapter = QuotesListAdapter(viewDataBinding.myQuotesViewModel!!, activity)
            val layoutManager = LinearLayoutManager(activity)
            quotes_list_rv.layoutManager = layoutManager
            quotes_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            quotes_list_rv.adapter = adapter
        }
    }
}
