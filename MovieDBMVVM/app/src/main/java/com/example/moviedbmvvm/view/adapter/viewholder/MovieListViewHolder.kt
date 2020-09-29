package com.example.moviedbmvvm.view.adapter.viewholder

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbmvvm.viewmodel.MovieListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_movie_list_item.view.*
import com.example.moviedbmvvm.BR
import com.example.moviedbmvvm.data.model.Item

import com.example.moviedbmvvm.data.model.MovieResponse
import com.example.moviedbmvvm.view.MovieDetailActivity
import kotlin.reflect.typeOf

class MovieListViewHolder constructor(
    private val dataBinding: ViewDataBinding,
    private val movieListViewModel: MovieListViewModel
) : RecyclerView.ViewHolder(dataBinding.root) {

    val posterImage = itemView.poster
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load("https://image.tmdb.org/t/p/w500"+itemData.poster_path).into(posterImage);

        itemView.setOnClickListener{
            val context = itemView.context
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra("title", itemData.title)
            intent.putExtra("budget", itemData.budget)
            intent.putExtra("overview", itemData.overview)
            intent.putExtra("poster_path","https://image.tmdb.org/t/p/w500"+ itemData.poster_path)
            intent.putExtra("release_date", itemData.release_date)
            intent.putExtra("vote_average", itemData.vote_average)
            context.startActivity(intent)

        }
    }
}