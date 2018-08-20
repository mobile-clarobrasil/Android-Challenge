package com.example.henry.forkit.data.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "meals")
@Parcelize
class Meal(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var idMeal: String = "",
        var strMeal: String = "",
        var strCategory: String = "",
        var strArea: String = "",
        var strInstructions: String = "",
        var strMealThumb: String = "",
        var strIngredient1: String? = "",
        var strIngredient2: String? = "",
        var strIngredient3: String? = "",
        var strIngredient4: String? = "",
        var strIngredient5: String? = "",
        var strIngredient6: String? = "",
        var strIngredient7: String? = "",
        var strIngredient8: String? = "",
        var strIngredient9: String? = "",
        var strIngredient10: String? = "",
        var strIngredient11: String? = "",
        var strIngredient12: String? = "",
        var strIngredient13: String? = "",
        var strIngredient14: String? = "",
        var strIngredient15: String? = "",
        var strIngredient16: String? = "",
        var strIngredient17: String? = "",
        var strIngredient18: String? = "",
        var strIngredient19: String? = "",
        var strIngredient20: String? = "",
        var strMeasure1: String? = "",
        var strMeasure2: String? = "",
        var strMeasure3: String? = "",
        var strMeasure4: String? = "",
        var strMeasure5: String? = "",
        var strMeasure6: String? = "",
        var strMeasure7: String? = "",
        var strMeasure8: String? = "",
        var strMeasure9: String? = "",
        var strMeasure10: String? = "",
        var strMeasure11: String? = "",
        var strMeasure12: String? = "",
        var strMeasure13: String? = "",
        var strMeasure14: String? = "",
        var strMeasure15: String? = "",
        var strMeasure16: String? = "",
        var strMeasure17: String? = "",
        var strMeasure18: String? = "",
        var strMeasure19: String? = "",
        var strMeasure20: String? = ""
): Parcelable
/*{

    companion object {
        val TABLE_NAME = "meals"
        val COLUMN_ID = "id"
    }
    fun tableModel(): String{
        return (
                "CREATE TABLE " + TABLE_NAME + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "idMeal TEXT,"
                        + "strMeal TEXT,"
                        + "strArea TEXT,"
                        + "strCategory TEXT,"
                        + "strInstructions TEXT,"
                        + "strMealThumb TEXT,"
                        + "strIngredient1 TEXT,"
                        + "strIngredient2 TEXT,"
                        + "strIngredient3 TEXT,"
                        + "strIngredient4 TEXT,"
                        + "strIngredient5 TEXT,"
                        + "strIngredient6 TEXT,"
                        + "strIngredient7 TEXT,"
                        + "strIngredient8 TEXT,"
                        + "strIngredient9 TEXT,"
                        + "strIngredient10 TEXT,"
                        + "strIngredient11 TEXT,"
                        + "strIngredient12 TEXT,"
                        + "strIngredient13 TEXT,"
                        + "strIngredient14 TEXT,"
                        + "strIngredient15 TEXT,"
                        + "strIngredient16 TEXT,"
                        + "strIngredient17 TEXT,"
                        + "strIngredient18 TEXT,"
                        + "strIngredient19 TEXT,"
                        + "strIngredient20 TEXT,"
                        + "strMeasure1 TEXT,"
                        + "strMeasure2 TEXT,"
                        + "strMeasure3 TEXT,"
                        + "strMeasure4 TEXT,"
                        + "strMeasure5 TEXT,"
                        + "strMeasure6 TEXT,"
                        + "strMeasure7 TEXT,"
                        + "strMeasure8 TEXT,"
                        + "strMeasure9 TEXT,"
                        + "strMeasure10 TEXT,"
                        + "strMeasure11 TEXT,"
                        + "strMeasure12 TEXT,"
                        + "strMeasure13 TEXT,"
                        + "strMeasure14 TEXT,"
                        + "strMeasure15 TEXT,"
                        + "strMeasure16 TEXT,"
                        + "strMeasure17 TEXT,"
                        + "strMeasure18 TEXT,"
                        + "strMeasure19 TEXT,"
                        + "strMeasure20 TEXT)")
    }
}*/

