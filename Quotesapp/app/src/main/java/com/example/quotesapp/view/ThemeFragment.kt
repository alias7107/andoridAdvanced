package com.example.quotesapp.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quotesapp.R
import com.example.quotesapp.data.model.Theme
import com.example.quotesapp.view.adapter.ThemeAdapter


class ThemeFragment: Fragment(), ThemeAdapter.ItemClickListener {
    lateinit var recyclerView: RecyclerView
    private  var themesCount: Int = 0
    private lateinit var totalThemes: TextView
    lateinit var listener: ThemeAdapter.ItemClickListener
    private lateinit var themeAdapter: ThemeAdapter
    private lateinit var prefs: SharedPreferences
    var selectedItemPos = -1
    var lastItemSelectedPos = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_theme, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bindViews(view)
        initAdapter()
        totalThemes.text = "Available Themes count:" +" " + availableThemes(newsGenerator()).availableThemeCount.toString()


    }

    private fun initAdapter() {

        recyclerView.layoutManager = GridLayoutManager(context,2 )
        themeAdapter =
            this.context.let {
                ThemeAdapter(
                    itemClickListener = this,
                    feedArrayList = newsGenerator()
                )

            }
        recyclerView.adapter = themeAdapter
        recyclerView.setHasFixedSize(true)
        recyclerView.setItemViewCacheSize(20)
    }

    private fun bindViews(view: View) = with(view){
        totalThemes = findViewById(R.id.themeCount)
        recyclerView = findViewById(R.id.theme_list_rv)
    }




    override fun itemClick(position: Int, item: Theme) {
//        Log.d(item?.themeImage.toString(), "onCLickAction")
//        Toast.makeText(activity, "Theme was changed!", Toast.LENGTH_SHORT)

        prefs = context?.getSharedPreferences("Theme", Context.MODE_PRIVATE)!!
        val editor = prefs.edit()
        item.themeImage.let { editor.putInt("selectedTheme", it)
        editor.putString("themeName", item.name)}
        editor.apply()
//        selectedItemPos = position
//        if(lastItemSelectedPos == -1)
//            lastItemSelectedPos = selectedItemPos
//        else {
//            themeAdapter.notifyItemChanged(lastItemSelectedPos)
//            lastItemSelectedPos = selectedItemPos
//        }
//        themeAdapter.notifyItemChanged(selectedItemPos)
//
////        themeAdapter.notifyDataSetChanged()



    }

    private fun newsGenerator(): MutableList<Theme> {
        val items: MutableList<Theme> = ArrayList<Theme>()
        val feed1 = Theme(1,
            R.drawable.shymbulak, "shymbulak"
        )
        items.add(feed1)
        val feed2 = Theme(
            2,
            R.drawable.kolsai_dark, "kolsai"
        )
        items.add(feed2)
        val feed3 = Theme(
            3,
            R.drawable.wooden, "wooden"
        )
        items.add(feed3)
        val feed4 = Theme(
            4,
            R.drawable.bamboo, "bamboo"
        )
        items.add(feed4)
        val feed5 = Theme(
            5,
            R.drawable.foggy_forest, "foggy_forest"
        )
        items.add(feed5)
        val feed6 = Theme(
            6,
            R.drawable.beachjpg, "beachjpg"
        )
        items.add(feed6)

        val feed7 = Theme(
            7,
            R.drawable.colorful2, "colorful2"
        )
        items.add(feed7)
        val feed8 = Theme(
            8,
            R.drawable.colorful3, "colorful3"
        )
        items.add(feed8)

        return items
    }

}

internal fun availableThemes(themes: MutableList<Theme>?): CountResult{
    return if (themes == null || themes.isEmpty()){
        CountResult(0)
    } else{
        val totalThemes = themes.size
        CountResult(availableThemeCount = totalThemes)
    }
}
data class CountResult(val availableThemeCount: Int)