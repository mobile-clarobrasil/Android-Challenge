package com.example.henry.forkit.ui.meals

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.henry.forkit.R
import com.example.henry.forkit.data.entity.Meal
import com.example.henry.forkit.interfaces.ListItemHandler
import com.example.henry.forkit.presentation.MealPresenter
import com.example.henry.forkit.presentation.MealViewModel
import com.example.henry.forkit.presentation.RetrieveDataController
import com.example.henry.forkit.ui.mealdetails.MealDetailsActivity
import com.example.henry.forkit.utils.hideKeyboard
import kotlinx.android.synthetic.main.meals_fragment.*


class MealsFragment: Fragment(), RetrieveDataController, ListItemHandler{

    private val mealListAdapter: MealListAdapter by lazy { MealListAdapter(this) }
    private var mealRecyclerView: RecyclerView? = null
    private var searchMealEt: EditText? = null
    private var swipeRefreshLayout: SwipeRefreshLayout? = null
    private var searchedWord: String = ""
    private val mealPresenter: MealPresenter by lazy{MealPresenter(context, this) }
    private val mealViewModel: MealViewModel by lazy {
        ViewModelProviders.of(activity!!).get(MealViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.meals_fragment, container, false)
        mealRecyclerView = view.findViewById(R.id.mealList)
        searchMealEt = view?.findViewById(R.id.searchMealEt)
        swipeRefreshLayout = view?.findViewById(R.id.swipeContainer)
        setupRecyclerView()
        setSwipeToRefresh()
        searching()
        observeSearchedList()
        return view
    }

    fun newInstance(): MealsFragment = MealsFragment()

    private fun observeSearchedList(){
        mealViewModel.getSearchedList().observe(this, Observer { it ->
            hideInitMessage()
            it?.let {
                if(it.isEmpty()) showNotFoundMessage()
            }
            mealListAdapter.update(it!!)
        })
    }

    private fun setupRecyclerView(){
        mealRecyclerView?.layoutManager = LinearLayoutManager(context)
        mealRecyclerView?.adapter = mealListAdapter
    }

    private fun searching(){
        searchMealEt?.setOnKeyListener{ view, keyCode, _ ->
            if(keyCode == 66){
                hideNotFoundMessage()
                hideKeyboard(context, view)
                val currentSearch= searchMealEt?.text.toString()
                if(searchedWord != currentSearch) {
                    mealListAdapter.update(mutableListOf())
                    hideInitMessage()
                    showProgress()
                    searchedWord = currentSearch
                    mealPresenter.searchMeals(searchedWord)
                }
            }
            false
        }
    }
    private fun setSwipeToRefresh(){
        swipeRefreshLayout?.setColorSchemeResources(R.color.colorAccent)
        swipeRefreshLayout?.setOnRefreshListener{
            if(searchedWord != ""){
                mealPresenter.searchMeals(searchedWord)
            }else{
                swipeRefreshLayout?.isRefreshing = false
            }
        }
    }

    override fun onSuccessRetrieveData(data: MutableList<Meal>) {
        mealListAdapter.update(data)
        if(!data.isEmpty()){
            mealViewModel.setSearchList(data)
        }
        hideProgress()
        swipeRefreshLayout?.isRefreshing = false
    }

    override fun onErrorRetrieveData(message: String) {
        mealViewModel.setSearchList(mutableListOf())
        hideProgress()
        swipeRefreshLayout?.isRefreshing = false
    }

    override fun onItemPress(view: View, position: Int) {
        val detailActivity = Intent(context, MealDetailsActivity::class.java)
        detailActivity.putExtra("meal", mealListAdapter.dataset[position])
        startActivity(Intent(detailActivity))
    }

    private fun showProgress(){ progress?.visibility = View.VISIBLE }
    private fun hideProgress(){ progress?.visibility = View.GONE }
    private fun hideInitMessage(){
        initSearchImage.visibility = View.GONE
        initSearchMessage.visibility = View.GONE
    }
    private fun hideNotFoundMessage(){
        notFoundMessage.visibility = View.GONE
        notFoundImage.visibility = View.GONE
    }
    private fun showNotFoundMessage(){
        notFoundMessage.visibility = View.VISIBLE
        notFoundImage.visibility = View.VISIBLE
    }



}