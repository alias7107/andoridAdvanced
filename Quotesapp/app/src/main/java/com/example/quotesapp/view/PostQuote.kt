package com.example.quotesapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.quotesapp.R
import com.example.quotesapp.viewModel.PostQuoteViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class PostQuote : Fragment() {
    private lateinit var author: EditText
    private lateinit var body: EditText
    private lateinit var post: Button
    private val postQuoteViewModel: PostQuoteViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = LayoutInflater.from(container?.context)
            .inflate(R.layout.fragment_post_quote, container, false)
        // Inflate the layout for this fragment

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)}


    private fun bindViews(view: View) = with(view){
        author = view.findViewById(R.id.tv_author)
        body = view.findViewById(R.id.tv_quote)
        post = view.findViewById(R.id.btnPost)
        val fragment = User()
        post.setOnClickListener {
//            Log.d(author.text.toString(), body.text.toString())
            postQuoteViewModel.PostQuote(author.text.toString(), body.text.toString())
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, fragment)
                ?.commit()

        }
    }
}

