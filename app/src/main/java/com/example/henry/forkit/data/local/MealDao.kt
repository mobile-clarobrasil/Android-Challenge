package com.example.henry.forkit.data.local
import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.henry.forkit.data.entity.Meal

@Dao
interface MealDao{
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun save(meal: Meal)

    @Query("SELECT * FROM meals ORDER BY id DESC")
    fun all(): LiveData<MutableList<Meal>>

    @Query("SELECT * FROM meals WHERE idMeal = :idMeal")
    fun checkExist(idMeal: String): Meal

    @Delete
    fun delete(meal: Meal)
}