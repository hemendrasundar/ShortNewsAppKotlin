package com.hemendra.shortnews.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hemendra.shortnews.Adapters.RvCategoryAdapter
import com.hemendra.shortnews.Adapters.RvNewsAdapter
import com.hemendra.shortnews.Interfaces.NewsService
import com.hemendra.shortnews.Listners.RecyclerItemClickListenr
import com.hemendra.shortnews.Models.News
import com.hemendra.shortnews.NewsFullActivity
import com.hemendra.shortnews.R
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    companion object {
        var BaseUrl = "https://script.google.com/"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_category.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rv_category.adapter = RvCategoryAdapter()

        //news api calling
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(NewsService::class.java)
        val call = service.getNews()
        call.enqueue(object : Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                if (response.code() == 200) {
                    val NewsResponse = response.body()!!
                    Log.i("response",response.body().items[1].title)
                    rv_news.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                    rv_news.adapter = RvNewsAdapter(applicationContext,NewsResponse)

                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                NewsError!!.text = t.message
            }
        })


    }
}