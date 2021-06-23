package com.example.quotesapp.view.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quotesapp.R
import com.example.quotesapp.data.api.SessionManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var sessionManager: SessionManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        sessionManager = SessionManager(this)
        if (sessionManager.fetchSessionId() == null) {
            val intent = Intent(this, LoginActivity::class.java)
            this.startActivity(intent)
        }
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_nav)
        val navController = findNavController(R.id.fragment)
        bottomNavigationView.setupWithNavController(navController)

    }
}