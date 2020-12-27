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
import kotlin.math.abs


class QuotesListAdapter  (private val QuotesListViewModel: QuotesListViewModel,
                          private val activity: FragmentActivity?
) :
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
        val like = holder.itemView.findViewById<ImageView>(R.id.iv_like)

        val rnd = Random()
        var color: Int = 0
        var rc: Int = 0
        var rf: Int = 0
        var gc: Int = 0
        var gf: Int = 0
        var bc: Int = 0
        var bf: Int = 0
        var fontColor: Int = 0
        while(abs(rc-rf) < 230 && abs(gc-gf) < 230 && abs(bc-bf) < 230 ){
            rc = rnd.nextInt(256)
            rf = rnd.nextInt(256)
            gc = rnd.nextInt(256)
            gf = rnd.nextInt(256)
            bc = rnd.nextInt(256)
            bf = rnd.nextInt(256)

        }
        color = Color.argb(255,rc, gc, bc)
        fontColor = Color.argb(255, rf, gf, bf)

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