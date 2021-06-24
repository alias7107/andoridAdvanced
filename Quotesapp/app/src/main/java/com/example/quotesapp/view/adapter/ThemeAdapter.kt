package com.example.quotesapp.view.adapter

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Theme
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tags_list_item.view.*

class ThemeAdapter(
    feedArrayList: MutableList<Theme>,
    itemClickListener: ItemClickListener?
) :
    RecyclerView.Adapter<ThemeAdapter.MyViewHolder>() {
    var themeList: MutableList<Theme>
    private val listener: ItemClickListener?
    private var selectedItem = 0
    private lateinit var prefs : SharedPreferences
    private var chosenTheme = ""


    init {
        Theme.themeList = feedArrayList
        themeList = feedArrayList
        this.listener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.theme_item, parent, false)!!
        prefs = parent.context?.getSharedPreferences("Theme", Context.MODE_PRIVATE)!!
        selectedItem = prefs.getInt("themePosition", 0)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val modelFeed = Theme.themeList[position]
        Picasso.get().load(modelFeed.themeImage).fit().centerCrop().into(holder.ivTheme)
        holder.itemView.setOnClickListener{
            listener?.  itemClick(position, modelFeed)
            val previousItem = selectedItem
            selectedItem = position
            notifyItemChanged(previousItem)
            notifyItemChanged(position)
        }
        if(selectedItem == position){
            holder.choosen.visibility = View.VISIBLE
        }
        else{
            holder.choosen.visibility = View.INVISIBLE
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

