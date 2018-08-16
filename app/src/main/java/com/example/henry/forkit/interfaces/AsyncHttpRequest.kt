package com.example.henry.forkit.interfaces

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.AsyncTask
import com.example.henry.forkit.domain.Meal
import com.example.henry.forkit.utils.Converter
import org.json.JSONObject
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class AsyncSearchMeal: AsyncTask<String, Int, MutableList<Meal>>(){
    override fun doInBackground(vararg params: String?): MutableList<Meal> {
        val url = params[0]
        val search = params[1]

        val meals: MutableList<Meal> = mutableListOf()

        try {
            val url = URL(url+search)
            val httpRequest: HttpURLConnection = url.openConnection() as HttpURLConnection
            httpRequest.requestMethod = "GET"
            httpRequest.setRequestProperty("Content-Type", "application/json")
            try {
                httpRequest.doOutput = true
                httpRequest.setChunkedStreamingMode(0)

                //val outputStream =  BufferedOutputStream(httpRequest.outputStream)
                //val outputStreamWriter = OutputStreamWriter(outputStream)
                //outputStreamWriter.write(data)
                //outputStream.flush()
                //outputStream.close()

                val response = httpRequest.inputStream
                response.reader().forEachLine{
                    val data = JSONObject(it).getJSONArray("meals")
                    for (index in 0 until data.length()){
                        val meal = Converter().jsonToMeal(data.getJSONObject(index))
                        meals.add(meal)
                    }
                }
            }catch (e: Exception){
                e.printStackTrace()
            }finally {
                httpRequest.disconnect()
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
        return meals
    }
}

class AsyncImageLoader: AsyncTask<String, Unit, BitmapDrawable?>(){
    override fun doInBackground(vararg params: String?): BitmapDrawable?{
        val url = params[0]
        var httpRequest: HttpURLConnection? = null
        var bitmapDrawable: BitmapDrawable? = null
        try {
            httpRequest = URL(url).openConnection() as HttpURLConnection
            httpRequest.requestMethod = "GET"
            bitmapDrawable = BitmapDrawable(BitmapFactory.decodeStream(httpRequest.content as InputStream))
        }catch (e: Exception) {
            e.printStackTrace()
        }finally {
            httpRequest?.disconnect()
        }
        return bitmapDrawable
    }
}