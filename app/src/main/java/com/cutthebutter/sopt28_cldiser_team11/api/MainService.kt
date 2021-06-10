package com.cutthebutter.sopt28_cldiser_team11.api

import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseFoodCategory
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import retrofit2.http.GET

interface MainService {

    @GET("/api/main/category")
    fun getFoodCategory(
    ):  retrofit2.Call<ResponseFoodCategory>

    @GET("/api/main/lastOrder")
    fun getRecentRestaurant(
    ): retrofit2.Call<ResponseRecentRestaurant>
}