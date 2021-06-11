package com.cutthebutter.sopt28_cldiser_team11.inner.model

import com.google.gson.annotations.SerializedName

data class ResponseMenu(
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
        @SerializedName("__v")
        val v: Int,
        @SerializedName("_id")
        val id: String,
        @SerializedName("detailMenu")
        val detailMenu: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("price")
        val price: String,
        @SerializedName("storeIdx")
        val storeIdx: String,
        @SerializedName("title")
        val title: String
    )
}