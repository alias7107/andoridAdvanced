package com.example.moviedbmvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.moviedbmvvm.R
import com.squareup.picasso.Picasso


class MovieDetailActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_detail)
        val title: TextView = findViewById(R.id.tvMovieTitle)
        val poster: ImageView = findViewById(R.id.ivFull)
        val overview: TextView = findViewById(R.id.tvPlot)
        val release_year: TextView = findViewById(R.id.tvReleaseYear)
        val release_date: TextView = findViewById(R.id.tvReleaseDate)
        val vote_average: TextView = findViewById(R.id.tvRating)
        val banner: ImageView = findViewById(R.id.ivBanner)

        title.text = intent.getCharSequenceExtra("title")
        overview.text = intent.getCharSequenceExtra("overview")
        release_year.text = intent.getCharSequenceExtra("release_date").substring(0,4)
        release_date.text = intent.getCharSequenceExtra("release_date")
        vote_average.text = intent.getCharSequenceExtra("vote_average")
        Picasso.get().load(intent.getStringExtra("poster_path")).into(poster)
        Picasso.get().load(intent.getStringExtra("poster_path")).into(banner)

    }


}