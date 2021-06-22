package com.example.quotesapp.view.adapter.viewHolder.QuoteListViewHolder


import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.view.*
import com.example.quotesapp.viewModel.QuoteDetailViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.quotes_list_item.view.*

abstract class BaseViewHolder constructor(
      val dataBinding: ViewDataBinding,
     private val quotesListViewModel: QuotesListViewModel,
     val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {
    fun setup(itemData: Item){
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        val ivLike = itemView.findViewById<ImageView>(R.id.iv_like)
        val tvLike  = itemView.findViewById<TextView>(R.id.tv_like)
        itemView.setOnClickListener{
            navigate(it, itemData)
        }
        if(itemData.user_details.favorite){
            ivLike.setImageResource(R.drawable.ic_licked)
        } else {
            ivLike.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        }


        itemView.iv_like.setOnClickListener {
            if(!itemData.user_details.favorite){
                quotesListViewModel.favQuote(itemData.id).observeForever(
                    Observer { tvLike.text = it.favorites_count }
                )
                itemView.iv_like.setImageResource(R.drawable.ic_licked)
                itemData.user_details.favorite = true }
            else{
                quotesListViewModel.unfavQuote(itemData.id).observeForever(
                    {tvLike.text = it.favorites_count}
                )
                itemView.iv_like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                itemData.user_details.favorite = true
            }

        }
    }

    abstract fun navigate(view: View, itemData: Item)

}