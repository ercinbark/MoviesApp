package com.ercin.moviesapp.data.remote

import com.ercin.moviesapp.util.Constant
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    fun getApiService():ApiService{
        val retrofit=Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getOkHttpClient())
            .build()

        return retrofit.create(ApiService::class.java)
    }

    private fun getOkHttpClient():OkHttpClient{
        val client=OkHttpClient.Builder()
        client.addInterceptor(RequestInterceptor())
        return client.build()
    }
}