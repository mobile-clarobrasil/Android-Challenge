package com.example.henry.forkit.ui.favorites

import android.app.AlertDialog
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.interfaces.ListItemLongPressHandler
import com.example.henry.forkit.presentation.MealViewModel
import com.example.henry.forkit.ui.mealdetails.MealDetailsActivity
import com.example.henry.forkit.ui.meals.MealListAdapter
import kotlinx.android.synthetic.main.favorite_meal_fragment.*
import kotlinx.android.synthetic.main.favorite_meal_fragment.view.*

class FavoritesFragment: Fragment(), ListItemHandler, ListItemLongPressHandler{

    private val mealListAdapter: MealListAdapter by lazy { MealListAdapter(this, this) }
    private var mealRecyclerView: RecyclerView? = null
    private val ITEM_MENU_OPTIONS = arrayOf("Open Meal", "Delete Meal")
    private val ITEM_MENU_OPTION_OPEN = 0
    private val ITEM_MENU_OPTION_DELETE = 1
    private val favoriteMealFirstList: MutableList<Meal> = mutableListOf()
    private val mealViewModel: MealViewModel by lazy {
        ViewModelProviders.of(this).get(MealViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.favorite_meal_fragment, container, false)
        mealRecyclerView = view.findViewById(R.id.favoriteMealsList)
        setupRecyclerView()
        observeFavoriteMeals()
        view.searchFavoriteMeal.addTextChangedListener(object : TextWatcher{
            var search: String? = ""
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                search = s?.toString()
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s.toString().trim() != "") {
                    val copy = favoriteMealFirstList
                    val filtered = mutableListOf<Meal>()

                    if(search?.trim()?.length!! < s.toString().length){
                        filtered.addAll(mealListAdapter.dataset.filter {
                            it.strMeal.toLowerCase().contains(s.toString().toLowerCase())
                        }.toMutableList())
                    }else{
                        filtered.addAll(copy.filter {
                            it.strMeal.toLowerCase().contains(s.toString().toLowerCase())
                        }.toMutableList())
                    }
                    mealListAdapter.update(filtered)

                }else{
                    mealListAdapter.update(favoriteMealFirstList)
                }
            }
        })
        return view
    }

    fun newInstance(): FavoritesFragment = FavoritesFragment()

    private fun observeFavoriteMeals(){
        mealViewModel.allFavorites()?.observe(this, Observer {
            val data = it?.toMutableList()
            if(data != null){
                mealListAdapter.update(data)
                favoriteMealFirstList.addAll(data)
                if(data.count() > 0){
                    hideNoFavoritesInfo()
                }else{
                    showNoFavoritesInfo()
                }
            }
        })
    }

    private fun setupRecyclerView(){
        mealRecyclerView?.layoutManager = GridLayoutManager(context, 2)
        mealRecyclerView?.adapter = mealListAdapter
    }

    override fun onItemPress(view: View, position: Int) = openDetailActivity(position)

    override fun onItemLongPress(view: View?, position: Int){
        AlertDialog.Builder(context)
                .setItems(ITEM_MENU_OPTIONS) { _: DialogInterface, item: Int ->
                    when(item){
                        ITEM_MENU_OPTION_OPEN -> openDetailActivity(position)
                        ITEM_MENU_OPTION_DELETE -> mealViewModel.delete(mealListAdapter.dataset[position])
                    }
                }.show()
    }

    private fun openDetailActivity(whichMeal: Int){
        val detailActivityIntent = Intent(context, MealDetailsActivity::class.java)
        detailActivityIntent.putExtra("meal", mealListAdapter.dataset[whichMeal])
        startActivity(detailActivityIntent)
    }
    private fun hideNoFavoritesInfo(){
        noFavoritesMessage.visibility = View.GONE
        noFavoritesImage.visibility = View.GONE
    }
    private fun showNoFavoritesInfo() {
        noFavoritesMessage.visibility = View.VISIBLE
        noFavoritesImage.visibility = View.VISIBLE
    }

}