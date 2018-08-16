package com.example.henry.forkit.ui.favorites

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.henry.forkit.R

class FavoritesFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.favorite_meal_fragment, container, false)
    }

    fun newInstance(): FavoritesFragment = FavoritesFragment()
}