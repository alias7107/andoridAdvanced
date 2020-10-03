package com.example.moviedbmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.moviedbmvvm.R

class MainActivity : AppCompatActivity() {
    private lateinit var fragmentManager: FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.main_nav_fragment, MovieListFragment()).commit()

    }

}