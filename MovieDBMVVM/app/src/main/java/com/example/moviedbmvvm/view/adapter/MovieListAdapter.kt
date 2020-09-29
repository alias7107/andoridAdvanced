package com.example.moviedbmvvm.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbmvvm.data.model.Item
import com.example.moviedbmvvm.data.model.MovieResponse
import com.example.moviedbmvvm.databinding.MovieListFragmentBinding
import com.example.moviedbmvvm.databinding.ViewMovieListItemBinding
import com.example.moviedbmvvm.view.adapter.viewholder.MovieListViewHolder
import com.example.moviedbmvvm.viewmodel.MovieListViewModel

class MovieListAdapter(private val movieListViewModel: MovieListViewModel) :
    RecyclerView.Adapter<MovieListViewHolder>() {
    var movieList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = ViewMovieListItemBinding.inflate(inflater, parent, false)
        return MovieListViewHolder(dataBinding, movieListViewModel)
    }

    override fun getItemCount() = movieList.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.setup(movieList[position])

    }

    fun updateMovieList(movieList: List<Item>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }
}