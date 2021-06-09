package com.cutthebutter.sopt28_cldiser_team11.main.model


import com.google.gson.annotations.SerializedName

data class ResponseRecentRestaurant(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
){
    data class Data(
        @SerializedName("distance")
        val distance: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("isFree")
        val isFree: Boolean,
        @SerializedName("reviewCount")
        val reviewCount: String,
        @SerializedName("star")
        val star: String,
        @SerializedName("title")
        val title: String
    )
}