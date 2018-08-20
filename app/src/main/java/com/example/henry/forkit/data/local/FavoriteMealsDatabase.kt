package com.example.henry.forkit.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.henry.forkit.data.entity.Meal

@Database(entities = [Meal::class], version = 2)
abstract class FavoriteMealsDatabase: RoomDatabase(){

    abstract val mealDao: MealDao

    companion object {
        var INSTANCE: FavoriteMealsDatabase? = null
        val DB_NAME = "favorites.db"
        /*val MIGRATION_2_3: Migration = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE film ADD COLUMN id INTEGER")
                database.execSQL("CREATE UNIQUE INDEX id ON Film(id)")
            }
        }*/

        fun getInstance(context: Context): FavoriteMealsDatabase?{
            if(INSTANCE == null){
                synchronized(FavoriteMealsDatabase::class.java){
                    INSTANCE = Room
                            .databaseBuilder(
                                    context.applicationContext,
                                    FavoriteMealsDatabase::class.java,
                                    DB_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }

    }

}