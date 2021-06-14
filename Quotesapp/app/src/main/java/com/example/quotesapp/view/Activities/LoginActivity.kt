package com.example.quotesapp.view.Activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.quotesapp.R
import androidx.lifecycle.Observer
import com.example.quotesapp.data.api.SessionManager
import com.example.quotesapp.data.model.LoginResponse
import com.example.quotesapp.data.model.SignInState
import com.example.quotesapp.viewModel.SignInViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LoginActivity: AppCompatActivity() {
    private lateinit var wrongDataText: TextView
    private lateinit var signInButton: Button
    private lateinit var username: EditText

    private lateinit var password: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var sessionManager: SessionManager
    private lateinit var sharedPreferences: SharedPreferences


    private val signInViewModel: SignInViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sessionManager = SessionManager(this)
        setContentView(R.layout.login)
        signInProcessing()
        bindViews()
    }

    private fun bindViews() {
        username = findViewById(R.id.evUsername)
        password = findViewById(R.id.evPassword)
        signInButton = findViewById(R.id.btnSignIn)
        progressBar = findViewById(R.id.progressBar)
        progressBar.visibility = View.GONE
        wrongDataText = findViewById(R.id.tvWrongData)
        sharedPreferences = getSharedPreferences("Login", Context.MODE_PRIVATE)



        signInButton.setOnClickListener {
            signInViewModel.signIn(username.text.toString(), password.text.toString())
        }
    }

    private fun signInProcessing() {

        signInViewModel.state.observe(this, Observer { result ->
            when(result) {

                is SignInState.ShowLoading ->{
                    progressBar.visibility = View.VISIBLE

                }

                is SignInState.HideLoading ->{
                    progressBar.visibility = View.GONE

                }

                is SignInState.Result ->{
                    val intent = Intent(this, MainActivity::class.java)
                    this.startActivity(intent)

                }

                is SignInState.FailedLoading ->{
                     signInViewModel.message.observe(this, Observer { message ->
                         wrongDataText.text = message
                    })
                }
            }
        })
    }
}