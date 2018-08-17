package com.example.henry.forkit.interfaces

import android.view.View

interface ListItemHandler {
    fun onItemPress(view: View, position: Int)
}
interface ListItemLongPressHandler{
    fun onItemLongPress(view: View?, position: Int)
}