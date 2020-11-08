package com.example.paginglibrary.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.paginglibrary.R
import com.example.paginglibrary.data.api.State
import com.example.paginglibrary.data.model.Item
import com.example.paginglibrary.data.model.MovieResponse
import com.example.paginglibrary.viewmodel.MovieListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_movie_list_item.view.*

class MovieListAdapter: PagedListAdapter<Item, MovieListAdapter.MovieViewHolder>(MOVIE_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context)

            .inflate(R.layout.view_movie_list_item, parent, false)

        return MovieViewHolder(view)

    }



    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        movie?.let { holder.bind(it) }

    }



    class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val title = view.title
        private val relase = view.relase_date
        private val rating = view.rating
        private val poster = view.poster



        fun bind(movie: Item) {
            title.text = movie.title
            relase.text = movie.release_date
            rating.text = movie.vote_average

            Picasso.get().load("https://image.tmdb.org/t/p/w500"+movie.poster_path).into(poster);
        }
    }



    companion object {

        private val MOVIE_COMPARATOR = object : DiffUtil.ItemCallback<Item>() {

            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id


            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                newItem == oldItem

        }

    }
}