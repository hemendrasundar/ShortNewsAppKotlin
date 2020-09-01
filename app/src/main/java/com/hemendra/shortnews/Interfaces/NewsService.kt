package com.hemendra.shortnews.Interfaces

import com.hemendra.shortnews.Models.News
import retrofit2.Call
import retrofit2.http.GET

interface NewsService {

        @GET("macros/s/AKfycbzFuWsXrzHSo5I2NiEsP0q1D09pu40mqLxVyDWMEMIkyqHJS54/exec?action=getNews")
        fun getNews(): Call<News>

}