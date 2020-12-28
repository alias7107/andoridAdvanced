package com.example.quotesapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentUserBinding
import com.example.quotesapp.view.Activities.LoginActivity
import com.example.quotesapp.viewModel.UserProfileViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class User : Fragment() {
    private lateinit var username: TextView
    private lateinit var email: TextView
    private lateinit var post: Button
    private lateinit var see: Button
    private lateinit var logout: Button
    private val userprofile: UserProfileViewModel by viewModel()
    private lateinit var viewDataBinding: FragmentUserBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var prefLike: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_user, container, false)
        // Inflate the layout for this fragment

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)

//        Log.d(data.value.toString(), "usermame")
//        data.observe(viewLifecycleOwner, Observer {
//            if(it!=null)
//                viewDataBinding.profileItem?.login= it.login
//
//        })
    }

    private fun bindViews(view: View) = with(view){
        username = view.findViewById(R.id.tv_name)
        email = view.findViewById(R.id.tv_address)
        sharedPreferences = context.getSharedPreferences("Login", Context.MODE_PRIVATE)!!
        username.text = sharedPreferences.getString("username", null)!!
        email.text = sharedPreferences.getString("email", null)!!
        post = view.findViewById(R.id.makeQuote)
        val fragment = PostQuote()
        post.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(
                R.id.fragment, fragment)
                ?.commit()

        }
        see = view.findViewById(R.id.myActivity)
        val activityFragment = myQuotes()
        see.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()?.addToBackStack(null)?.replace(
                R.id.fragment, activityFragment)
                ?.commit()
        }

        logout = view.findViewById(R.id.logout)
        logout.setOnClickListener {
            sharedPreferences.edit().clear().commit()
            prefLike = activity?.getSharedPreferences("Like", Context.MODE_PRIVATE)!!
            prefLike.edit().clear().commit()

            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            activity?.finish()
        }

    }


}