package com.example.henry.forkit.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.henry.forkit.R
import com.example.henry.forkit.ui.meals.MealActivity
import kotlin.concurrent.thread

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        thread(start = true) {
            try {
                Thread.sleep(4000L)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            } finally {
                startActivity(Intent(this@MainActivity, MealActivity::class.java))
                finish()
            }
        }

    }
}
