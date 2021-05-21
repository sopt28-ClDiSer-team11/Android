package com.cutthebutter.sopt28_cldiser_team11.inner

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cutthebutter.sopt28_cldiser_team11.databinding.ItemMenuBinding


class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    val menuList = mutableListOf<MenuData>()

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
        holder: MenuViewHolder, position: Int
    ) {
        holder.onBind(menuList[position])
    }

    class MenuViewHolder(
        private val binding: ItemMenuBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(menuData: MenuData) {
            binding.menuTitle.text = menuData.menu_title
            binding.menuPrice.text = menuData.menu_price
            binding.menuDetail.text = menuData.menu_detail
        }
    }
}