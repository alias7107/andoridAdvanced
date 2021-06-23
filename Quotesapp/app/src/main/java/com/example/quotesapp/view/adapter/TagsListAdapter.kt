package com.example.quotesapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.databinding.TagsListItemBinding
import com.example.quotesapp.view.adapter.viewHolder.TagsListViewHolder
import com.example.quotesapp.viewModel.TagsListViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tags_list_item.view.*
import java.util.*


class TagsListAdapter internal constructor(
    private val TagsListViewModel: TagsListViewModel,
                       private val activity: FragmentActivity?) :
    RecyclerView.Adapter<TagsListViewHolder>() {
    var tagsList: List<Tags> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagsListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding = TagsListItemBinding.inflate(inflater, parent, false)
        return TagsListViewHolder(dataBinding,  activity)
    }

    override fun getItemCount(): Int {
        return tagsList.size
    }

    override fun onBindViewHolder(holder: TagsListViewHolder, position: Int) {
        holder.setup(tagsList[position])

        if(tagsList[position].name.equals("religion")||tagsList[position].name.equals("god")){
            Picasso.get().load(R.drawable.religion_god).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("happiness")){
            Picasso.get().load(R.drawable.happiness).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("life")){
            Picasso.get().load(R.drawable.life).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("work")){
            Picasso.get().load(R.drawable.work).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("men")){
            Picasso.get().load(R.drawable.men).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("nature")){
            Picasso.get().load(R.drawable.kolsai).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("great")){
            Picasso.get().load(R.drawable.shymbulak).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("love")){
            Picasso.get().load(R.drawable.lovejpg).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("truth")){
            Picasso.get().load(R.drawable.beachjpg).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("knowledge")){
            Picasso.get().load(R.drawable.knowledge).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else if(tagsList[position].name.equals("science")){
            Picasso.get().load(R.drawable.science).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
        else {
            val images = intArrayOf(R.drawable.life ,R.drawable.men,R.drawable.lovejpg, R.drawable.science,R.drawable.knowledge,R.drawable.happiness, R.drawable.work, R.drawable.kolsai, R.drawable.shymbulak, R.drawable.beachjpg,R.drawable.wooden, R.drawable.foggy_forest)
            val rand = Random()
            Picasso.get().load(images[rand.nextInt(images.size)]).fit().centerCrop().placeholder(R.drawable.kolsai).into(holder.itemView.ivTag)
        }
    }

    fun updateTagsList(tagsList: List<Tags>) {
        this.tagsList = tagsList
        notifyDataSetChanged()
    }
}