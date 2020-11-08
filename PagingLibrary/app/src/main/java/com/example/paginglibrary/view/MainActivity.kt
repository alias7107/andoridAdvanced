package com.example.paginglibrary.view

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.paginglibrary.R
import com.example.paginglibrary.data.api.State
import com.example.paginglibrary.view.adapter.MovieListAdapter
import com.example.paginglibrary.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val adapter = MovieListAdapter()

            movie_list_rv.layoutManager = LinearLayoutManager(this)



            val itemViewModel = ViewModelProviders.of(this)

                .get(MovieListViewModel::class.java)



            itemViewModel.moviePageList.observe(this, Observer {

                adapter.submitList(it)

            })



            movie_list_rv.adapter = adapter

        }

}