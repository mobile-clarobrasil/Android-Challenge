package com.example.henry.forkit.ui.meals

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.MenuItem
import com.example.henry.forkit.R
import com.example.henry.forkit.ui.favorites.FavoritesFragment
import kotlinx.android.synthetic.main.activity_meals.*

class MealActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meals)
        openFragment(MealsFragment().newInstance())
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when(item.itemId){
            R.id.bottom_navigation_search -> fragment = MealsFragment().newInstance()
            R.id.bottom_navigation_favorites -> fragment = FavoritesFragment().newInstance()
        }
        if(fragment != null)
            openFragment(fragment)
        return true
    }

    private fun openFragment(fragment: Fragment){
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}
