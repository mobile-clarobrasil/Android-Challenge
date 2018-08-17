package com.example.henry.forkit.data.local

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.henry.forkit.data.entity.Meal
import android.content.ContentValues
import android.provider.ContactsContract.CommonDataKinds.Note



class DatabaseHelper(context: Context?): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    val tableModel = Meal().tableModel()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(tableModel)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + tableModel)
        onCreate(db)
    }

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "MEAL.db"
    }

    /* Methods to handle data in the database */

    fun insert(meal: Meal): Long{
        val db = this.writableDatabase
        val values = ContentValues()
        values.put("idMeal", meal.idMeal)
        values.put("strMeal", meal.strMeal)
        values.put("strArea", meal.strArea)
        values.put("strCategory", meal.strCategory)
        values.put("strInstructions", meal.strInstructions)
        values.put("strMealThumb", meal.strMealThumb)
        values.put("strIngredient1", meal.strIngredient1)
        values.put("strIngredient2", meal.strIngredient2)
        values.put("strIngredient3", meal.strIngredient3)
        values.put("strIngredient4", meal.strIngredient4)
        values.put("strIngredient5", meal.strIngredient5)
        values.put("strIngredient6", meal.strIngredient6)
        values.put("strIngredient7", meal.strIngredient7)
        values.put("strIngredient8", meal.strIngredient8)
        values.put("strIngredient9", meal.strIngredient9)
        values.put("strIngredient10", meal.strIngredient10)
        values.put("strIngredient11", meal.strIngredient11)
        values.put("strIngredient12", meal.strIngredient12)
        values.put("strIngredient13", meal.strIngredient13)
        values.put("strIngredient14", meal.strIngredient14)
        values.put("strIngredient15", meal.strIngredient15)
        values.put("strIngredient16", meal.strIngredient16)
        values.put("strIngredient17", meal.strIngredient17)
        values.put("strIngredient18", meal.strIngredient18)
        values.put("strIngredient19", meal.strIngredient19)
        values.put("strIngredient20", meal.strIngredient20)

        values.put("strMeasure1", meal.strMeasure1)
        values.put("strMeasure2", meal.strMeasure2)
        values.put("strMeasure3", meal.strMeasure3)
        values.put("strMeasure4", meal.strMeasure4)
        values.put("strMeasure5", meal.strMeasure5)
        values.put("strMeasure6", meal.strMeasure6)
        values.put("strMeasure7", meal.strMeasure7)
        values.put("strMeasure8", meal.strMeasure8)
        values.put("strMeasure9", meal.strMeasure9)
        values.put("strMeasure10", meal.strMeasure10)
        values.put("strMeasure11", meal.strMeasure11)
        values.put("strMeasure12", meal.strMeasure12)
        values.put("strMeasure13", meal.strMeasure13)
        values.put("strMeasure14", meal.strMeasure14)
        values.put("strMeasure15", meal.strMeasure15)
        values.put("strMeasure16", meal.strMeasure16)
        values.put("strMeasure17", meal.strMeasure17)
        values.put("strMeasure18", meal.strMeasure18)
        values.put("strMeasure19", meal.strMeasure19)
        values.put("strMeasure20", meal.strMeasure20)

        val id = db.insert(Meal.TABLE_NAME, null, values)
        db.close()
        return id
    }

    fun getMeal(id: String): Meal{
        val db = this.readableDatabase
        val cursor = db.query(Meal.TABLE_NAME,
                arrayOf("idMeal", "strMeal", "strArea", "strCategory", "strInstructions", "strMealThumb",
                        "strIngredient1", "strIngredient2", "strIngredient3", "strIngredient4",
                        "strIngredient5", "strIngredient6", "strIngredient7", "strIngredient8",
                        "strIngredient9", "strIngredient10", "strIngredient11", "strIngredient12",
                        "strIngredient13", "strIngredient14", "strIngredient15", "strIngredient16",
                        "strIngredient17", "strIngredient18", "strIngredient19", "strIngredient20",
                        "strMeasure1", "strMeasure2","strMeasure3","strMeasure4",
                        "strMeasure5", "strMeasure6","strMeasure7","strMeasure8",
                        "strMeasure9", "strMeasure10","strMeasure11","strMeasure12",
                        "strMeasure13", "strMeasure14","strMeasure15","strMeasure16",
                        "strMeasure17", "strMeasure18","strMeasure19","strMeasure20"
                ),
                Meal.COLUMN_ID + "=?",
                arrayOf(id), null, null, null, null)
        cursor?.moveToFirst()
        val meal = Meal(
                cursor.getString(cursor.getColumnIndex("idMeal")),
                cursor.getString(cursor.getColumnIndex("strMeal")),
                cursor.getString(cursor.getColumnIndex("strArea")),
                cursor.getString(cursor.getColumnIndex("strCategory")),
                cursor.getString(cursor.getColumnIndex("strInstructions")),
                cursor.getString(cursor.getColumnIndex("strMealThumb")),
                cursor.getString(cursor.getColumnIndex("strIngredient1")),
                cursor.getString(cursor.getColumnIndex("strIngredient2")),
                cursor.getString(cursor.getColumnIndex("strIngredient3")),
                cursor.getString(cursor.getColumnIndex("strIngredient4")),
                cursor.getString(cursor.getColumnIndex("strIngredient5")),
                cursor.getString(cursor.getColumnIndex("strIngredient6")),
                cursor.getString(cursor.getColumnIndex("strIngredient7")),
                cursor.getString(cursor.getColumnIndex("strIngredient8")),
                cursor.getString(cursor.getColumnIndex("strIngredient9")),
                cursor.getString(cursor.getColumnIndex("strIngredient10")),
                cursor.getString(cursor.getColumnIndex("strIngredient11")),
                cursor.getString(cursor.getColumnIndex("strIngredient12")),
                cursor.getString(cursor.getColumnIndex("strIngredient13")),
                cursor.getString(cursor.getColumnIndex("strIngredient14")),
                cursor.getString(cursor.getColumnIndex("strIngredient15")),
                cursor.getString(cursor.getColumnIndex("strIngredient16")),
                cursor.getString(cursor.getColumnIndex("strIngredient17")),
                cursor.getString(cursor.getColumnIndex("strIngredient18")),
                cursor.getString(cursor.getColumnIndex("strIngredient19")),
                cursor.getString(cursor.getColumnIndex("strIngredient20")),
                cursor.getString(cursor.getColumnIndex("strMeasure1")),
                cursor.getString(cursor.getColumnIndex("strMeasure2")),
                cursor.getString(cursor.getColumnIndex("strMeasure3")),
                cursor.getString(cursor.getColumnIndex("strMeasure4")),
                cursor.getString(cursor.getColumnIndex("strMeasure5")),
                cursor.getString(cursor.getColumnIndex("strMeasure6")),
                cursor.getString(cursor.getColumnIndex("strMeasure7")),
                cursor.getString(cursor.getColumnIndex("strMeasure8")),
                cursor.getString(cursor.getColumnIndex("strMeasure9")),
                cursor.getString(cursor.getColumnIndex("strMeasure10")),
                cursor.getString(cursor.getColumnIndex("strMeasure11")),
                cursor.getString(cursor.getColumnIndex("strMeasure12")),
                cursor.getString(cursor.getColumnIndex("strMeasure13")),
                cursor.getString(cursor.getColumnIndex("strMeasure14")),
                cursor.getString(cursor.getColumnIndex("strMeasure15")),
                cursor.getString(cursor.getColumnIndex("strMeasure16")),
                cursor.getString(cursor.getColumnIndex("strMeasure17")),
                cursor.getString(cursor.getColumnIndex("strMeasure18")),
                cursor.getString(cursor.getColumnIndex("strMeasure19")),
                cursor.getString(cursor.getColumnIndex("strMeasure20")))
        cursor.close()
        return meal
    }


    @SuppressLint("Recycle")
    fun getAllMeals(): MutableList<Meal> {
        val meals = arrayListOf<Meal>()
        val selectQuery = "SELECT * FROM " + Meal.TABLE_NAME + " ORDER BY id DESC"
        val db = this.writableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val meal = Meal(
                        cursor.getString(cursor.getColumnIndex("idMeal")),
                        cursor.getString(cursor.getColumnIndex("strMeal")),
                        cursor.getString(cursor.getColumnIndex("strArea")),
                        cursor.getString(cursor.getColumnIndex("strCategory")),
                        cursor.getString(cursor.getColumnIndex("strInstructions")),
                        cursor.getString(cursor.getColumnIndex("strMealThumb")),
                        cursor.getString(cursor.getColumnIndex("strIngredient1")),
                        cursor.getString(cursor.getColumnIndex("strIngredient2")),
                        cursor.getString(cursor.getColumnIndex("strIngredient3")),
                        cursor.getString(cursor.getColumnIndex("strIngredient4")),
                        cursor.getString(cursor.getColumnIndex("strIngredient5")),
                        cursor.getString(cursor.getColumnIndex("strIngredient6")),
                        cursor.getString(cursor.getColumnIndex("strIngredient7")),
                        cursor.getString(cursor.getColumnIndex("strIngredient8")),
                        cursor.getString(cursor.getColumnIndex("strIngredient9")),
                        cursor.getString(cursor.getColumnIndex("strIngredient10")),
                        cursor.getString(cursor.getColumnIndex("strIngredient11")),
                        cursor.getString(cursor.getColumnIndex("strIngredient12")),
                        cursor.getString(cursor.getColumnIndex("strIngredient13")),
                        cursor.getString(cursor.getColumnIndex("strIngredient14")),
                        cursor.getString(cursor.getColumnIndex("strIngredient15")),
                        cursor.getString(cursor.getColumnIndex("strIngredient16")),
                        cursor.getString(cursor.getColumnIndex("strIngredient17")),
                        cursor.getString(cursor.getColumnIndex("strIngredient18")),
                        cursor.getString(cursor.getColumnIndex("strIngredient19")),
                        cursor.getString(cursor.getColumnIndex("strIngredient20")),
                        cursor.getString(cursor.getColumnIndex("strMeasure1")),
                        cursor.getString(cursor.getColumnIndex("strMeasure2")),
                        cursor.getString(cursor.getColumnIndex("strMeasure3")),
                        cursor.getString(cursor.getColumnIndex("strMeasure4")),
                        cursor.getString(cursor.getColumnIndex("strMeasure5")),
                        cursor.getString(cursor.getColumnIndex("strMeasure6")),
                        cursor.getString(cursor.getColumnIndex("strMeasure7")),
                        cursor.getString(cursor.getColumnIndex("strMeasure8")),
                        cursor.getString(cursor.getColumnIndex("strMeasure9")),
                        cursor.getString(cursor.getColumnIndex("strMeasure10")),
                        cursor.getString(cursor.getColumnIndex("strMeasure11")),
                        cursor.getString(cursor.getColumnIndex("strMeasure12")),
                        cursor.getString(cursor.getColumnIndex("strMeasure13")),
                        cursor.getString(cursor.getColumnIndex("strMeasure14")),
                        cursor.getString(cursor.getColumnIndex("strMeasure15")),
                        cursor.getString(cursor.getColumnIndex("strMeasure16")),
                        cursor.getString(cursor.getColumnIndex("strMeasure17")),
                        cursor.getString(cursor.getColumnIndex("strMeasure18")),
                        cursor.getString(cursor.getColumnIndex("strMeasure19")),
                        cursor.getString(cursor.getColumnIndex("strMeasure20")))
                meals.add(meal)
            } while (cursor.moveToNext())
        }
        db.close()
        return meals
    }

    fun deleteMeal(meal: Meal) {
        val db = this.writableDatabase
        db.delete(Meal.TABLE_NAME,"idMeal = ?", arrayOf(meal.idMeal))
        db.close()
    }

    fun checkExist(idMeal: String): Int {
        val countQuery = "SELECT  * FROM " + Meal.TABLE_NAME + " WHERE idMeal = "+ idMeal
        val db = this.readableDatabase
        val cursor = db.rawQuery(countQuery, null)
        val count = cursor.count
        cursor.close()
        return count
    }

}