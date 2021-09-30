package com.example.rxjavaretrofit.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private val myRetrofit by lazy {

        val r = Retrofit.Builder()
            .baseUrl("https://grocery-second-app.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        r   // return value of lambda expression
    }

    val apiService: ApiService by lazy {
        myRetrofit.create(ApiService::class.java)
    }
}