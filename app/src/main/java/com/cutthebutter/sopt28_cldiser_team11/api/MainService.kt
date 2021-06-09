package com.cutthebutter.sopt28_cldiser_team11.api

import android.telecom.Call
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseBannerData
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseFoodCategory
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import retrofit2.http.GET

interface MainService {

    @GET("/api/main/banner")
    fun getMainBanner(
    ) : retrofit2.Call<ResponseBannerData>

    @GET("/api/main/category")
    fun getFoodCategory(
    ):  Call<ResponseFoodCategory>

    @GET("/api/main/category")
    fun getRecentRestaurant(
    ): Call<ResponseRecentRestaurant>

}