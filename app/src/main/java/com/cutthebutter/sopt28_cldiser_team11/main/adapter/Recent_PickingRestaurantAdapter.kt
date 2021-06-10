package com.cutthebutter.sopt28_cldiser_team11.main.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemRecentPickingRestaurantBinding
import com.cutthebutter.sopt28_cldiser_team11.inner.InnerActivity
import com.cutthebutter.sopt28_cldiser_team11.main.Recent_PickingRestaurantData
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant

class Recent_PickingRestaurantAdapter : RecyclerView.Adapter<Recent_PickingRestaurantAdapter.Recent_PickingRestaurantViewHolder>(){
    val RecentpickingRestaurantDatas = mutableListOf<ResponseRecentRestaurant.RecentRestaurantData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Recent_PickingRestaurantViewHolder {
        val binding = ItemRecentPickingRestaurantBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return Recent_PickingRestaurantViewHolder(binding)
    }

    override fun getItemCount(): Int = RecentpickingRestaurantDatas.size

    override fun onBindViewHolder(
        holder: Recent_PickingRestaurantViewHolder,
        position: Int
    ) {
        holder.onBind(RecentpickingRestaurantDatas[position])
    }

    class Recent_PickingRestaurantViewHolder(
        private val binding : ItemRecentPickingRestaurantBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(Recent_pickingRestaurantData: ResponseRecentRestaurant.RecentRestaurantData){
            Glide.with(itemView)
                .load(Recent_pickingRestaurantData.image).placeholder(R.drawable.picking_img_1).into(binding.recentPickingImg)
            binding.recentPickingTitle.text = Recent_pickingRestaurantData.title
            binding.starScore.text = Recent_pickingRestaurantData.star
            binding.gradeScore.text = Recent_pickingRestaurantData.reviewCount
            binding.recentDistance.text = Recent_pickingRestaurantData.distance

            itemView.setOnClickListener {view ->
                val intent = Intent(view.context, InnerActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }
}