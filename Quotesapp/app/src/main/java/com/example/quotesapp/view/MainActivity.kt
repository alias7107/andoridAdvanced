package com.example.quotesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Tags
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private var tagsListFragment = TagsListFragment()
    private var searchableQuotesListFragment = SearchableQuotesListFragment()
    private lateinit var active: Fragment
    private lateinit var fragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().add(R.id.main_nav_fragment, tagsListFragment, "1").hide(tagsListFragment).commit()
        fragmentManager.beginTransaction().add(R.id.main_nav_fragment, searchableQuotesListFragment, "2").hide(searchableQuotesListFragment).commit()

        active = tagsListFragment

        bottomNavigationView = findViewById(R.id.bottom_nav)

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.categories -> {
                    fragmentManager.popBackStack()
                    fragmentManager.beginTransaction().hide(active).show(tagsListFragment).addToBackStack(null).commit()
                    active = tagsListFragment
                    Log.d(active.toString(), "activnyi")


                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    fragmentManager.popBackStack()
                    fragmentManager.beginTransaction().hide(active)
                        .show(searchableQuotesListFragment).addToBackStack(null).commit()
                    active = searchableQuotesListFragment
                    Log.d(active.toString(), "activnyi")

                    return@setOnNavigationItemSelectedListener true

                }
            }
            false
        }


    }

}