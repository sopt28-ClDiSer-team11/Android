package com.cutthebutter.sopt28_cldiser_team11.inner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemMenuBinding
import com.cutthebutter.sopt28_cldiser_team11.inner.model.ResponseMenu


class MenuAdapter: RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    val menuList = mutableListOf<ResponseMenu.Data>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun getItemCount(): Int = menuList.size

    override fun onBindViewHolder(
        holder: MenuViewHolder,
        position: Int
    ) {
        holder.onBind(menuList[position])
    }


    class MenuViewHolder(
        private val binding: ItemMenuBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun onBind(menuData: ResponseMenu.Data){
            Glide.with(itemView)
                .load(menuData.image).placeholder(R.drawable.menu_image).into(binding.menuImg)
            binding.menuTitle.text = menuData.title
            binding.menuPrice.text = menuData.price
            binding.menuDetail.text = menuData.detailMenu
        }
    }
}