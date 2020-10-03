package com.example.moviedbmvvm.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.moviedbmvvm.R
import com.example.moviedbmvvm.BR
import com.example.moviedbmvvm.data.model.Item
import com.example.moviedbmvvm.databinding.MovieDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_detail.view.*
import kotlinx.android.synthetic.main.view_movie_list_item.view.*

class MovieDetailFragment constructor(private val itemDetail: Item ): Fragment() {
    private lateinit var viewDataBinding: MovieDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.movie_detail, container, false)
        val view= viewDataBinding.root
        Log.d("detail", itemDetail.title)

        viewDataBinding.setVariable(BR.itemDetail, itemDetail)
        val posterImage = view.ivFull
        val bannerImage = view.ivBanner
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+itemDetail.poster_path).into(posterImage)
        Picasso.get().load("https://image.tmdb.org/t/p/w500"+itemDetail.poster_path).into(bannerImage)


       return view
    }

}