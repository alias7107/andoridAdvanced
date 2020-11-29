//package com.example.quotesapp.view
//
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import com.example.quotesapp.data.model.Tags
//import com.example.quotesapp.databinding.QuotesListFragmentBinding
//import com.example.quotesapp.view.adapter.QuotesListAdapter
//import com.example.quotesapp.viewModel.QuotesListViewModel
//import org.koin.android.viewmodel.ext.android.viewModel
//
//class QuotesListActivityconstructor(private val selectedTag: Tags): AppCompatActivity()  {
//    private lateinit var viewDataBinding: QuotesListFragmentBinding
//    private lateinit var adapter: QuotesListAdapter
//    private val QuotesListViewModel: QuotesListViewModel by viewModel()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        viewDataBinding = QuotesListFragmentBinding.inflate(inflater, container, false).apply {
//            setLifecycleOwner(viewLifecycleOwner)
//        }
//        viewData
//    }
//
//    private fun setObservers() {
//        viewDataBinding.viewModel?.fetchQuotesList(selectedTag.name)?.observe(viewLifecycleOwner, Observer {
//            adapter.updateQuoteList(it)
//
//
//        })
//
//    }
//}