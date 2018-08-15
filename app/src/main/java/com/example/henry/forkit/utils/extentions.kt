package com.example.henry.forkit.utils

import android.widget.ImageView
import com.example.henry.forkit.interfaces.AsyncImageLoader

fun ImageView.load(url: String?){
    this.setImageDrawable(AsyncImageLoader().execute(url).get())
}