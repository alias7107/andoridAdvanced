package com.example.quotesapp.view.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Resources
import android.net.Uri
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quotesapp.R
import org.koin.android.ext.android.inject
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.quotesapp.data.api.SessionManager
import com.example.quotesapp.data.model.LoginData
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.User
import com.example.quotesapp.databinding.LoginBinding
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.viewModel.SignInViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity: AppCompatActivity() {
    private lateinit var wrongDataText: TextView
    private lateinit var signInButton: Button
    private lateinit var username: EditText

    private lateinit var password: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var loginResponse: LoginResponse
    private lateinit var sessionManager: SessionManager
    private lateinit var sharedPreferences: SharedPreferences

    private val signInViewModel: SignInViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)
        setContentView(R.layout.login)
        bindViews()
    }

    private fun bindViews() {
        username = findViewById(R.id.evUsername)
        password = findViewById(R.id.evPassword)
        signInButton = findViewById(R.id.btnSignIn)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        var isSuccessful: String?
        wrongDataText = findViewById(R.id.tvWrongData)
        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)



        signInButton.setOnClickListener {
            signInViewModel.signIn(username.text.toString(), password.text.toString())
            isSuccessful = sharedPreferences.getString("username", null)
            if (isSuccessful != null) {
                val intent = Intent(this, MainActivity::class.java)
                this.startActivity(intent)
            }

            else{
                wrongDataText.setText("Wrong data")
            }
//            Log.d(loginResponse.user_token, "user-token")


        }


    }

    private fun signInProcessing() {






    }
}