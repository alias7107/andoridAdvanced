package com.example.quotesapp.view.adapter.viewHolder

import android.content.Context
import android.content.SharedPreferences
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.viewModel.QuotesListViewModel
import com.example.quotesapp.BR
import com.example.quotesapp.R
import com.example.quotesapp.view.QuoteDetailFragment
import com.example.quotesapp.view.SearchableQuotesListFragment
import com.example.quotesapp.view.TagsListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.quotes_list_item.view.*


class QuotesListViewHodler constructor(
    val dataBinding: ViewDataBinding,
    private val QuotesListViewModel: QuotesListViewModel,
    val activity: FragmentActivity?
) : RecyclerView.ViewHolder(dataBinding.root) {




    fun setup(itemData: Item) {
        dataBinding.setVariable(BR.itemData, itemData)
        dataBinding.executePendingBindings()

        lateinit var prefLike: SharedPreferences
        var favCount:Int=itemData.favorites_count.toInt()

        val ivLike = itemView.findViewById<ImageView>(R.id.iv_like)
        val tvLike  = itemView.findViewById<TextView>(R.id.tv_like)

        prefLike = activity?.getSharedPreferences("Like", Context.MODE_PRIVATE)!!
        if(prefLike.getBoolean(itemData.id.toString(), false)){
            ivLike.setBackgroundResource(R.drawable.ic_licked)

        }
        itemView.setOnClickListener{

            val fragment = QuoteDetailFragment(itemData, QuotesListViewModel)
            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.fragment, fragment)?.addToBackStack(null)?.commit()

        }

        if(itemData.favourite){
            itemView.iv_like.setImageResource(R.drawable.ic_licked)
        } else {
            itemView.iv_like.setImageResource(R.drawable.ic_baseline_favorite_border_24)

        }


        itemView.iv_like.setOnClickListener {
            if(!itemData.favourite){
            QuotesListViewModel.favQuote(itemData.id)
            itemView.iv_like.setImageResource(R.drawable.ic_licked)
            favCount = favCount + 1
            tvLike.setText(favCount.toString())
            val editor = prefLike.edit()
            editor.putBoolean(itemData.id.toString(), true)
            editor.apply()
            itemData.favourite = true}
            else{
                itemView.iv_like.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                favCount = favCount - 1
                tvLike.setText(favCount.toString())
                val editor = prefLike.edit()
                editor.putBoolean(itemData.id.toString(), false)
                editor.apply()
                itemData.favourite = false
            }

        }


//        itemView.setOnClickListener{
//
//            val service = MovieDetailFragment(itemData)
//            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.main_nav_fragment, fragment)?.commit()
//
//        }
    }

}