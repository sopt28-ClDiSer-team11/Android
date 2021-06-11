package com.cutthebutter.sopt28_cldiser_team11.api

import com.cutthebutter.sopt28_cldiser_team11.inner.model.ResponseMenu
import com.cutthebutter.sopt28_cldiser_team11.inner.model.ResponseRestaurantDetail
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseBanner
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseFoodCategory
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {

    @GET("/api/main/category")
    fun getFoodCategory(
    ):  retrofit2.Call<ResponseFoodCategory>

    @GET("/api/main/lastOrder")
    fun getRecentRestaurant(
    ): retrofit2.Call<ResponseRecentRestaurant>

    @GET("/api/main/banner")
    fun getBanner(
    ): retrofit2.Call<ResponseBanner>

    @GET("/api/detail/{storeIdx}/menu")
    fun getMenu(
        @Path ("storeIdx") storeIdx : String
    ): retrofit2.Call<ResponseMenu>

    @GET("/api/detail/{storeIdx}")
    fun getRestaurantDetail(
        @Path("storeIdx") storeIdx: String
    ): retrofit2.Call<ResponseRestaurantDetail>
}