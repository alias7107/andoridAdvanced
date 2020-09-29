package com.example.moviedbmvvm.view.adapter.viewholder

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

//        itemView.onClick {
//            val bundle = bundleOf("url" to itemData.html_url)
//            itemView.findNavController()
//                .navigate(R.id.action_repoListFragment_to_repoDetailFragment, bundle)
//        }
    }
}