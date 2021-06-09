package com.cutthebutter.sopt28_cldiser_team11.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "http://3.35.48.11:5000/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()

    val mainService : MainService = retrofit.create(MainService::class.java)

}