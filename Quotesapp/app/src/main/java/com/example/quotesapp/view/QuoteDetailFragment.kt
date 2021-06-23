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
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.navArgs
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.squareup.picasso.Picasso
import com.example.quotesapp.BR
import com.example.quotesapp.databinding.FragmentDetailBinding
import com.example.quotesapp.viewModel.QuoteDetailViewModel
import com.example.quotesapp.viewModel.QuotesListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.tags_list_item.view.*
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*


class QuoteDetailFragment: Fragment() {
    private lateinit var viewDataBinding: FragmentDetailBinding
    private lateinit var itemDetail: Item
    private lateinit var ivLike:ImageView
    private  val detailViewModel: QuoteDetailViewModel by viewModel()
    val arg: QuoteDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        viewDataBinding = FragmentDetailBinding.inflate(inflater, container, false).apply{
            setLifecycleOwner (viewLifecycleOwner )
        }
        viewDataBinding.detailViewModel = detailViewModel
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViews(view)
        setObservers()
    }

    private fun bindViews(view: View){
        val prefs:SharedPreferences = activity?.getSharedPreferences("Theme", Context.MODE_PRIVATE)!!
        val ivTheme  = view.findViewById<ConstraintLayout>(R.id.quoteDetailFragment)
        val tvContent  = view.findViewById<TextView>(R.id.content)
        val tvLike  = view.findViewById<TextView>(R.id.favCount)
        val tvAuthor  = view.findViewById<TextView>(R.id.author)
        ivLike = view.findViewById<ImageView>(R.id.like)
        val ivShare = view.findViewById<ImageView>(R.id.share)
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
                if (!itemDetail.user_details.favorite) {
                    detailViewModel.favQuote(itemDetail.id).observe(viewLifecycleOwner,{result->
                        tvLike.text = result.favorites_count
                    })
                    ivLike.setBackgroundResource(R.drawable.ic_licked)
                    itemDetail.user_details.favorite = true

                } else {
                    detailViewModel.unfavQuote(itemDetail.id).observe(viewLifecycleOwner,{
                        tvLike.text = it.favorites_count
                    })
                    itemDetail.user_details.favorite = false
                    ivLike.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
                }
            }
            ivShare.setOnClickListener {
                share()
            }
        }
    }

    private fun setObservers(){
        viewDataBinding.detailViewModel?.getQuote(arg.quoteDetail)?.observe(viewLifecycleOwner, {
            itemDetail = it
            if(itemDetail.user_details.favorite){
                ivLike.setBackgroundResource(R.drawable.ic_licked)
            }
            viewDataBinding.setVariable(BR.itemDetail, itemDetail)

        })

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