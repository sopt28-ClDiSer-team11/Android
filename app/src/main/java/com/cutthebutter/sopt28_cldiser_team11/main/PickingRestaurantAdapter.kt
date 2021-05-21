package com.cutthebutter.sopt28_cldiser_team11.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemPickingRestaurantBinding

class PickingRestaurantAdapter : RecyclerView.Adapter<PickingRestaurantAdapter.PickingRestaurantViewHolder>(){
    val pickingRestaurantDatas = mutableListOf<PickingRestaurantData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PickingRestaurantViewHolder {
        val binding = ItemPickingRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PickingRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int = pickingRestaurantDatas.size

    override fun onBindViewHolder(
        holder: PickingRestaurantViewHolder,
        position: Int
    ) {
        holder.onBind(pickingRestaurantDatas[position])
    }

    class PickingRestaurantViewHolder(
        private val binding : ItemPickingRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(pickingRestaurantData: PickingRestaurantData){
            Glide.with(itemView).load(pickingRestaurantData.picking_img).placeholder(R.drawable.picking_img_1).into(binding.pickingImg)
            binding.pickingTitle.text = pickingRestaurantData.picking_title
            binding.starPoint.text = pickingRestaurantData.star_point
            binding.gradeAmount.text = pickingRestaurantData.grade_amount
            binding.distance.text=pickingRestaurantData.distance
        }
    }
}