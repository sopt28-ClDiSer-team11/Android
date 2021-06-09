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

class Recent_PickingRestaurantAdapter : RecyclerView.Adapter<Recent_PickingRestaurantAdapter.Recent_PickingRestaurantViewHolder>(){
    val RecentpickingRestaurantDatas = mutableListOf<Recent_PickingRestaurantData>()

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
        fun onBind(Recent_pickingRestaurantData: Recent_PickingRestaurantData){
            Glide.with(itemView)
                .load(Recent_pickingRestaurantData.recent_picking_img).placeholder(R.drawable.picking_img_1).into(binding.recentPickingImg)
            binding.recentPickingTitle.text = Recent_pickingRestaurantData.recent_picking_title
            binding.starScore.text = Recent_pickingRestaurantData.star_score
            binding.gradeScore.text = Recent_pickingRestaurantData.grade_score
            binding.recentDistance.text = Recent_pickingRestaurantData.recent_distance

            itemView.setOnClickListener {view ->
                val intent = Intent(view.context, InnerActivity::class.java)
                view.context.startActivity(intent)
            }
        }
    }
}