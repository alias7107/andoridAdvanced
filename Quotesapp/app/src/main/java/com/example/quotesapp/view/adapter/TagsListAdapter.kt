package com.example.quotesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.databinding.TagsListItemBinding
import com.example.quotesapp.view.adapter.viewHolder.TagsListViewHolder
import com.example.quotesapp.viewModel.TagsListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tags_list_item.view.*
import java.util.*


class TagsListAdapter (private val TagsListViewModel: TagsListViewModel,
                       private val activity: FragmentActivity?) :
    RecyclerView.Adapter<TagsListViewHolder>() {
    var tagsList: List<Tags> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = TagsListItemBinding.inflate(inflater, parent, false)
        val context = parent.context
        return TagsListViewHolder(dataBinding, TagsListViewModel, activity)
    }

    override fun getItemCount(): Int {
        if (tagsList.size > 25){
            return 25
        }
        else {
            return tagsList.size
        }
    }

    override fun onBindViewHolder(holder: TagsListViewHolder, position: Int) {
        holder.setup(tagsList[position])
        val images = intArrayOf(R.drawable.happiness, R.drawable.work, R.drawable.kolsai, R.drawable.shymbulak, R.drawable.beachjpg,R.drawable.wooden, R.drawable.foggy_forest)
        val rand = Random()

//        holder.itemView.ivTag.setBackgroundResource(images[rand.nextInt(images.size)])

        Picasso.get().load(images[rand.nextInt(images.size)]).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
//        holder.itemView.ivTag.setBackgroundResource(R.drawable.happiness)
//        if(tagsList[position].name.equals("religion")||tagsList[position].name.equals("god")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.religion_god)
//        }
//        else if(tagsList[position].name.equals("happiness")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.happiness)
//        }
//        else if(tagsList[position].name.equals("life")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.life)
//        }
//        else if(tagsList[position].name.equals("work")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.work)
//        }
//        else if(tagsList[position].name.equals("men")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.men)
//        }
//        else if(tagsList[position].name.equals("nature")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.kolsai)
//        }
//        else if(tagsList[position].name.equals("great")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.shymbulak)
//        }
//        else if(tagsList[position].name.equals("love")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.lovejpg)
//        }
//        else if(tagsList[position].name.equals("truth")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.beachjpg)
//        }
//        else if(tagsList[position].name.equals("knowledge")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.knowledge)
//        }
//        else if(tagsList[position].name.equals("science")){
//            holder.itemView.ivTag.setBackgroundResource(R.drawable.science)
//        }
//        else {
//
//
//        }



    }

    fun updateTagsList(tagsList: List<Tags>) {
        this.tagsList = tagsList
        notifyDataSetChanged()
    }
}