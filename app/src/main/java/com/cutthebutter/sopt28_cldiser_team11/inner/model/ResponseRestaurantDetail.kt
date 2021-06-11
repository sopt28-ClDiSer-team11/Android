package com.cutthebutter.sopt28_cldiser_team11.inner.model

import com.google.gson.annotations.SerializedName

data class ResponseRestaurantDetail(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
){
    data class Data(
        @SerializedName("__v")
        val v: Int,
        @SerializedName("_id")
        val id: Int,
        @SerializedName("cheetahImage")
        val cheetahImage: String,
        @SerializedName("fee")
        val fee: String,
        @SerializedName("minimumPrice")
        val minimumPrice: String,
        @SerializedName("minute")
        val minute: String,
        @SerializedName("notice")
        val notice: String,
        @SerializedName("review")
        val review: String,
        @SerializedName("star")
        val star: String,
        @SerializedName("title")
        val title: String
    )
}