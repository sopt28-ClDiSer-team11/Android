package com.cutthebutter.sopt28_cldiser_team11.main.model

import com.google.gson.annotations.SerializedName

data class ResponseBanner(
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
        @SerializedName("image")
        val image: String
    )
}