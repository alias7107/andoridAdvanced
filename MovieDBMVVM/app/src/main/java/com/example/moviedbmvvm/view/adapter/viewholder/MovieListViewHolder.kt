package com.example.moviedbmvvm.view.adapter.viewholder

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbmvvm.viewmodel.MovieListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.view_movie_list_item.view.*
import com.example.moviedbmvvm.BR
import com.example.moviedbmvvm.R
import com.example.moviedbmvvm.data.model.Item

import com.example.moviedbmvvm.data.model.MovieResponse
//import com.example.moviedbmvvm.view.MovieDetailActivity
import com.example.moviedbmvvm.view.MovieDetailFragment
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlin.reflect.typeOf

class MovieListViewHolder constructor(
    val dataBinding: ViewDataBinding,
    private val movieListViewModel: MovieListViewModel,
    val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {

    val posterImage = itemView.poster
    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        Picasso.get().load("https://image.tmdb.org/t/p/w500"+itemData.poster_path).into(posterImage);

        itemView.setOnClickListener{

            val fragment = MovieDetailFragment(itemData)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.commit()

        }
    }
}