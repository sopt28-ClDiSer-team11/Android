package com.cutthebutter.sopt28_cldiser_team11.main

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemFoodKindBinding
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemPickingRestaurantBinding
import com.cutthebutter.sopt28_cldiser_team11.inner.InnerActivity

class FoodKindAdapter : RecyclerView.Adapter<FoodKindAdapter.FoodKindViewHolder>() {
    val foodKindDatas = mutableListOf<FoodKindData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodKindViewHolder {
        val binding = ItemFoodKindBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodKindViewHolder(binding)
    }

    override fun getItemCount(): Int = foodKindDatas.size

    override fun onBindViewHolder(
        holder: FoodKindViewHolder,
        position: Int
    ) {
        holder.onBind(foodKindDatas[position])
    }

    class FoodKindViewHolder(
        private val binding: ItemFoodKindBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(foodKindData: FoodKindData) {
            binding.foodKindTitle.text = foodKindData.foodName
            Glide.with(itemView).load(foodKindData.foodImage).placeholder(R.drawable.category_img_1).into(binding.foodImage)

        }
    }
}