package com.example.quotesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.quotesapp.R
import com.example.quotesapp.databinding.FragmentUserBinding
import com.example.quotesapp.viewModel.UserProfileViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class User : Fragment() {
    private lateinit var username: TextView
    private lateinit var post: Button
    private lateinit var see: Button
    private val userprofile: UserProfileViewModel by viewModel()
    private lateinit var viewDataBinding: FragmentUserBinding

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
//        username = view.findViewById(R.id.tv_name)
//        username.text = userprofile.getUsername().toString()

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

    }


}