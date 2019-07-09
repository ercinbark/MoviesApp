package com.ercin.moviesapp.data.remote

import com.ercin.moviesapp.util.Constant
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest=chain.request()
        val originalHttp=originalRequest.url

        val url=originalHttp.newBuilder().addQueryParameter("api_key",Constant.API_KEY).build()
        val request=originalRequest.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}