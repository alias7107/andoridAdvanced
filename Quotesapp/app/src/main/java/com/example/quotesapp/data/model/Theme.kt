package com.example.quotesapp.data.model

import java.io.Serializable

data class Theme (
    var id: Int,
    var themeImage: Int,
    var name: String
):
        Serializable{
    companion object {
        var themeList: MutableList<Theme> = ArrayList()
        
    }
}
