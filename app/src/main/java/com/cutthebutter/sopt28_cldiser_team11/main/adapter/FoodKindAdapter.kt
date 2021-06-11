package com.cutthebutter.sopt28_cldiser_team11.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemFoodKindBinding
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseFoodCategory

class FoodKindAdapter : RecyclerView.Adapter<FoodKindAdapter.FoodKindViewHolder>() {
    val foodKindDatas = mutableListOf<ResponseFoodCategory.Data>()

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
        fun onBind(foodKindData: ResponseFoodCategory.Data) {
            binding.foodKindTitle.text = foodKindData.title
            Glide.with(itemView).load(foodKindData.image).placeholder(R.drawable.category_img_1).into(binding.foodImage)

        }
    }
}