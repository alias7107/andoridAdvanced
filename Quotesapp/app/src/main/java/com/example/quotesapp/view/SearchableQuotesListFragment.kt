package com.example.quotesapp.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quotesapp.R
import com.example.quotesapp.databinding.SearchableQuotesListFragmentBinding
import com.example.quotesapp.view.adapter.QuoteListAdapter.SearchableQuotesListAdapter
import com.example.quotesapp.viewModel.QuotesListViewModel
import kotlinx.android.synthetic.main.searchable_quotes_list_fragment.*
import org.koin.android.viewmodel.ext.android.viewModel

class SearchableQuotesListFragment : Fragment(){
    private lateinit var viewDataBinding: SearchableQuotesListFragmentBinding
    private lateinit var adapter: SearchableQuotesListAdapter
    private val QuotesListViewModel: QuotesListViewModel by viewModel()
    private lateinit var searchWord: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = SearchableQuotesListFragmentBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(viewLifecycleOwner)
        }
        setHasOptionsMenu(true)
        searchWord = "default"
        viewDataBinding.searchViewModel = QuotesListViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel()


    }

    private fun setUpViewModel() {
        viewDataBinding.searchViewModel?.fetchSearchableQuotesList(searchWord)
        setupAdapter()
        setObservers()

    }

    private fun setObservers() {
        viewDataBinding.searchViewModel?.fetchSearchableQuotesList(searchWord)?.observe(viewLifecycleOwner, Observer {
            adapter.updateQuoteList(it)


        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.searchViewModel
        if (viewModel != null) {
            adapter = SearchableQuotesListAdapter(viewDataBinding.searchViewModel!!, activity)
            val layoutManager = LinearLayoutManager(activity)
            searchable_quotes_list_rv.layoutManager = layoutManager
            searchable_quotes_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            searchable_quotes_list_rv.adapter = adapter

        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_search, menu)
        val searchMenuItem = menu.findItem(R.id.action_search)
        val searchView = searchMenuItem?.actionView as SearchView
        searchView.queryHint = "Search"

        searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextChange(qString: String): Boolean {
                if (qString.length > 2) {
                    searchWord = qString
                    setUpViewModel()
                }
                return false
            }

            override fun onQueryTextSubmit(qString: String): Boolean {
                setUpViewModel()
                return false
            }
        })
        super.onCreateOptionsMenu(menu, inflater)
    }
}
