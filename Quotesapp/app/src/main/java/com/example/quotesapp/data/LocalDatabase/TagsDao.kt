package com.example.quotesapp.data.LocalDatabase

import android.content.Context
import android.nfc.Tag
import androidx.room.*
import com.example.quotesapp.data.model.Tags
import com.example.quotesapp.utils.Constants

@Dao
interface TagsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Tags>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(post: Tags?)

    @Query("SELECT * FROM " + Constants.TAGS_TABLE + " " + "LIMIT 20")
    fun getAll(): List<Tags>
}

@Database(entities = [Tags::class], version = 1, exportSchema = false)
abstract class TagsDatabase : RoomDatabase() {
    abstract fun tagDao(): TagsDao


    companion object {
        private var INSTANCE: TagsDatabase? = null
        fun getDatabase(context: Context): TagsDatabase {

            if (INSTANCE == null) {
                INSTANCE = createDb(context)
            }
            return INSTANCE!!
        }

        private fun createDb(context: Context): TagsDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                TagsDatabase::class.java,
                "tag.db"
            ).allowMainThreadQueries().build()
        }
    }

}