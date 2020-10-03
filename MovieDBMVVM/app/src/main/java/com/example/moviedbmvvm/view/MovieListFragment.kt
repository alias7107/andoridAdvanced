package com.example.moviedbmvvm.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviedbmvvm.databinding.MovieListFragmentBinding
import com.example.moviedbmvvm.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.movie_list_fragment.*
import androidx.lifecycle.Observer
import com.example.moviedbmvvm.view.adapter.MovieListAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class MovieListFragment : Fragment(){
    private lateinit var viewDataBinding: MovieListFragmentBinding
    private lateinit var adapter: MovieListAdapter
    private val movieListViewModel:MovieListViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = MovieListFragmentBinding.inflate(inflater, container, false).apply {
            setLifecycleOwner(viewLifecycleOwner)
        }
        viewDataBinding.viewmodel = movieListViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.viewmodel?.fetchMovieList()
        setupAdapter()
        setObservers()
    }

    private fun setObservers() {
        viewDataBinding.viewmodel?.movieListLive?.observe(viewLifecycleOwner, Observer {
            adapter.updateMovieList(it)


        })

    }

    private fun setupAdapter() {
        val viewModel = viewDataBinding.viewmodel
        if (viewModel != null) {
            adapter = MovieListAdapter(viewDataBinding.viewmodel!!, activity)
            val layoutManager = LinearLayoutManager(activity)
            movie_list_rv.layoutManager = layoutManager
            movie_list_rv.addItemDecoration(
                DividerItemDecoration(
                    activity,
                    layoutManager.orientation
                )
            )
            movie_list_rv.adapter = adapter
        }
    }
}
