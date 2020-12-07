package com.example.quotesapp.view.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Item
import com.example.quotesapp.databinding.QuotesListItemBinding
import com.example.quotesapp.view.adapter.viewHolder.QuotesListViewHodler
import com.example.quotesapp.viewModel.QuotesListViewModel
import java.util.*


class QuotesListAdapter  (private val QuotesListViewModel: QuotesListViewModel,
                          private val activity: FragmentActivity?) :
    RecyclerView.Adapter<QuotesListViewHodler>() {
    var quotesList: List<Item> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesListViewHodler {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = QuotesListItemBinding.inflate(inflater, parent, false)
        val context = parent.context
        return QuotesListViewHodler(dataBinding, QuotesListViewModel, activity)
    }

    override fun getItemCount() = quotesList.size

    override fun onBindViewHolder(holder: QuotesListViewHodler, position: Int) {
        val backImage=  holder.itemView.findViewById<ImageView>(R.id.iv_postPic)
        val text=  holder.itemView.findViewById<TextView>(R.id.title)
        val rnd = Random()
        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        val fontColor: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        backImage.setBackgroundColor(color)
        text.setTextColor(fontColor)

//        val rnd = Random()
//        val color: Int = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
//        holder.itemView.setBackgroundColor(color)
        holder.setup(quotesList[position])

    }

    fun updateQuoteList(quotesList: List<Item>) {
        this.quotesList = quotesList
        notifyDataSetChanged()
    }
}