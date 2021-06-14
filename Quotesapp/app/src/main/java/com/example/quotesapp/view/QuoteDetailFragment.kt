package com.example.quotesapp.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.squareup.picasso.Picasso
import com.example.quotesapp.BR
import com.example.quotesapp.databinding.FragmentDetailBinding
import com.example.quotesapp.viewModel.QuotesListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class QuoteDetailFragment constructor(private val itemDetail: Item, private val QuotesListViewModel: QuotesListViewModel ): Fragment() {
    private lateinit var viewDataBinding: FragmentDetailBinding
    private lateinit var prefLike: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        val view= viewDataBinding.root
        val prefs:SharedPreferences = activity?.getSharedPreferences("Theme", Context.MODE_PRIVATE)!!
        val ivTheme  = view.findViewById<ConstraintLayout>(R.id.quoteDetailFragment)
        val tvContent  = view.findViewById<TextView>(R.id.content)
        val tvLike  = view.findViewById<TextView>(R.id.favCount)
        val tvAuthor  = view.findViewById<TextView>(R.id.author)
        val ivLike = view.findViewById<ImageView>(R.id.like)
        val ivShare = view.findViewById<ImageView>(R.id.share)
        var favCount:Int=itemDetail.favorites_count.toInt()
        prefLike = context?.getSharedPreferences("Like", Context.MODE_PRIVATE)!!

        val image = prefs.getInt("selectedTheme", 0)
        val imageName = prefs.getString("themeName", null)

        if(image!=0) {
            ivTheme?.setBackgroundResource(image)
            if (imageName.equals("kolsai") || imageName.equals("foggy_forest") || imageName.equals("beachjpg")) {
                tvContent.setTextColor(resources.getColor(R.color.white))
            } else if (imageName.equals("bamboo") || imageName.equals("colorful2") || imageName.equals(
                    "colorful3"
                )
            ) {
                tvLike.setTextColor(resources.getColor(R.color.black))
                tvAuthor.setTextColor(resources.getColor(R.color.black))

            }
            ivLike.setOnClickListener {
                QuotesListViewModel.favQuote(itemDetail.id)
                ivLike.setBackgroundResource(R.drawable.ic_licked)
                favCount = favCount + 1
                tvLike.setText(favCount.toString())
                val editor = prefLike.edit()
                 editor.putBoolean(itemDetail.id.toString(), true)
                editor.apply()
            }

            if(prefLike.getBoolean(itemDetail.id.toString(), false)){
                ivLike.setBackgroundResource(R.drawable.ic_licked)

            }

            ivShare.setOnClickListener {
                share()
            }
        }

        viewDataBinding.setVariable(BR.itemDetail, itemDetail)
        return view
    }


    private fun share() {
        try {
            val i = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    itemDetail.body + "\n" +  ":Author" + "\n" + itemDetail.author + "\n" + "Shared from the QuotesApp" + "\n"
                )
                type = "text/plain"

            }
            startActivity(Intent.createChooser(i, "Share with:"))
        } catch (e: Exception) {
            Toast.makeText(context, "Hmm...Sorry, /nCan not be shared", Toast.LENGTH_LONG).show()
        }
    }

}