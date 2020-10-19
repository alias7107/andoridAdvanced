package com.example.quotesapp.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.squareup.picasso.Picasso
import com.example.quotesapp.databinding.DetailActivityBinding
import com.example.quotesapp.BR


class QuoteDetailFragment constructor(private val itemDetail: Item ): Fragment() {
    private lateinit var viewDataBinding: DetailActivityBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.detail_activity, container, false)
        val view= viewDataBinding.root

        viewDataBinding.setVariable(BR.itemDetail, itemDetail)
        return view
    }

}