package com.cutthebutter.sopt28_cldiser_team11.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemOrderRankingBinding

class OrderRankingAdapter: RecyclerView.Adapter<OrderRankingAdapter.OrderRankingViewHolder>() {

    val orderRankingList = mutableListOf<OrderRankingData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrderRankingAdapter.OrderRankingViewHolder {
        val binding = ItemOrderRankingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderRankingViewHolder(binding)
    }

    override fun getItemCount(): Int = orderRankingList.size

    override fun onBindViewHolder(holder: OrderRankingViewHolder, position: Int) {
        holder.onBind(orderRankingList[position])
    }


    class OrderRankingViewHolder(
        private val binding: ItemOrderRankingBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(orderRankingData: OrderRankingData){
            Glide.with(itemView).load(orderRankingData.ranking_img).placeholder(R.drawable.ranking_img_1).into(binding.rankingImg)
            binding.rankingTitle.text = orderRankingData.ranking_title
            binding.starPoint.text = orderRankingData.star_point
            binding.gradeAmount.text = orderRankingData.grade_amount
            binding.distance.text = orderRankingData.distance

        }
    }
}