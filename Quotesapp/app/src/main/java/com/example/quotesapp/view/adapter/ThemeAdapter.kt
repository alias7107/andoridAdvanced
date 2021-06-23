package com.example.quotesapp.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Theme

class ThemeAdapter(
    feedArrayList: MutableList<Theme>,
    itemClickListener: ItemClickListener?
) :
    RecyclerView.Adapter<ThemeAdapter.MyViewHolder>() {
    var themeList: MutableList<Theme>
    private val listener: ItemClickListener?
    private var selectedItem = 0

    init {
        Theme.themeList = feedArrayList
        themeList = feedArrayList
        this.listener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.theme_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val modelFeed = Theme.themeList[position]
        holder.ivTheme.setImageResource(modelFeed.themeImage)
        holder.itemView.setOnClickListener{
            listener?.  itemClick(position, modelFeed)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)

        }
        if(selectedItem==position){
            holder.choosen.visibility = View.VISIBLE
        }
    }

    override fun getItemCount(): Int {
        return Theme.themeList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivTheme: ImageView
        var choosen: ImageView

        init {
            ivTheme = itemView.findViewById(R.id.theme_iv)
            choosen = itemView.findViewById(R.id.choosen)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    interface ItemClickListener {
        fun itemClick(position: Int, item: Theme)
    }

}

