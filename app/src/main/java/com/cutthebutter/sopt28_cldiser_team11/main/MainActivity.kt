package com.cutthebutter.sopt28_cldiser_team11.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodKindSectionFragment = FoodKindSectionFragment()
        val pickingRestaurantFragment = PickingRestaurantFragment()
        val recent_PickingRestaurantFragment = Recent_PickingRestaurantFragment()
        val orderRankingFragment = OrderRankingFragment()

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.food_kind_section_frag, foodKindSectionFragment)
        transaction.add(R.id.picking_frag, pickingRestaurantFragment)
        transaction.add(R.id.order_ranking_frag, orderRankingFragment)
        transaction.add(R.id.recent_picking_frag,recent_PickingRestaurantFragment)
        transaction.commit()

    }
}