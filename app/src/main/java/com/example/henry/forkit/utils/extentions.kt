package com.example.henry.forkit.utils

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.henry.forkit.interfaces.AsyncImageLoader

fun ImageView.load(url: String?){
    this.setImageDrawable(AsyncImageLoader().execute(url).get())
}


fun TextView.hideOrSetIfEmpty(data: String){
    if(data.isEmpty()){
        this.visibility = View.GONE
    }else{
        this.text = data
    }
}

/*
fun TextView.hideOrSetIfEmpty(field: String){
    if(field.isEmpty()){
        this.visibility = View.GONE
    }else{
        this.text = field
    }
}*/
