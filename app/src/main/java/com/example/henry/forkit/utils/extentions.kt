package com.example.henry.forkit.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView

/*fun ImageView.load(url: String?){
    this.setImageDrawable(AsyncImageLoader().execute(url).get())
}*/

fun TextView.hideOrSetIfEmpty(field: String?){
    if(field == null || field == "" || field == "null"){
        this.visibility = View.GONE
    }else {
        this.text = field
    }
}
fun hideKeyboard(context: Context?, view: View){
    val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}
