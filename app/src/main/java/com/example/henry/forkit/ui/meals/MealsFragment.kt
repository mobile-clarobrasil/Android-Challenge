package com.example.henry.forkit.ui.meals

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.example.henry.forkit.R
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.presentation.MealController
import com.example.henry.forkit.presentation.MealPresenter
import com.example.henry.forkit.ui.mealdetails.MealDetailsActivity
import kotlinx.android.synthetic.main.meals_fragment.*

class MealsFragment: Fragment(), MealController, ListItemHandler{

    private val mealListAdapter: MealListAdapter by lazy { MealListAdapter(this) }
    private var mealRecyclerView: RecyclerView? = null
    private val mealPresenter: MealPresenter by lazy { MealPresenter(this) }
    private var searchMealEt: EditText? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var searchedWord: String = ""

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.meals_fragment, container, false)
        mealRecyclerView = view.findViewById(R.id.meal_list)
        searchMealEt = view?.findViewById(R.id.searchMealEt)
        swipeRefreshLayout = view?.findViewById(R.id.swipeContainer)
        setupRecyclerView()
        setSwipeToRefresh()
        searching()
        return view
    }

    fun newInstance(): MealsFragment = MealsFragment()

    private fun setupRecyclerView(){
        mealRecyclerView?.layoutManager = LinearLayoutManager(context)
        mealRecyclerView?.adapter = mealListAdapter
    }

    private fun searching(){
        searchMealEt?.setOnKeyListener{_, i,_ ->
            if(i == 66){
                showProgress()
                searchedWord = searchMealEt?.text.toString()
                mealPresenter.searchMeals(searchedWord)
            }
            false
        }
    }
    private fun setSwipeToRefresh(){
        swipeRefreshLayout?.setColorSchemeResources(R.color.colorAccent)
        swipeRefreshLayout?.setOnRefreshListener{
            if(searchedWord != ""){
                showProgress()
                mealPresenter.searchMeals(searchedWord)
            }else{
                swipeRefreshLayout?.isRefreshing = false
            }
        }
    }

    override fun onSuccess(data: MutableList<Meal>) {
        mealListAdapter.update(data)
        swipeRefreshLayout?.isRefreshing = false
        hideProgress()
    }

    override fun onError(message: String) {
        mealListAdapter.update(mutableListOf())
        swipeRefreshLayout?.isRefreshing = false
        hideProgress()
    }

    override fun onItemClick(view: View, position: Int) {
        val detailActivity = Intent(context, MealDetailsActivity::class.java)
        detailActivity.putExtra("meal", mealListAdapter.dataset[position])
        startActivity(Intent(detailActivity))
    }

    private fun showProgress(){ progress?.visibility = View.VISIBLE }
    private fun hideProgress(){ progress?.visibility = View.GONE }
}