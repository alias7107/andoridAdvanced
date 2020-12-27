package com.example.quotesapp.view

import com.example.quotesapp.R
import com.example.quotesapp.data.model.Theme
import org.junit.Assert.*
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`

class ThemeFragmentTest{
    @Test
    fun getAvailableThemesCount_returnCount() {
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

        val result = availableThemes(items)
        assertThat(result.availableThemeCount, `is`(2))

    }

    @Test
    fun getAvailableThemesCount_returnCount_empty_returnsZeros() {

        val mutableList = mutableListOf<Theme>()
        val result = availableThemes(mutableList)

        assertThat(result.availableThemeCount, `is`(0))
    }



    @Test
    fun getAvailableThemesCount_returnCount_null_returnsZeros() {

        val result = availableThemes(null)
        assertThat(result.availableThemeCount, `is`(0))
    }
}