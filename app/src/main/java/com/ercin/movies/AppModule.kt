package com.ercin.movies

import com.ercin.movies.data.remote.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule= module {

    //single { (get() as Retrofit).create(ApiService::class.java) }

}