package com.cutthebutter.sopt28_cldiser_team11.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.api.ServiceCreator
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityMainBinding
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseBanner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bannerRetrofit()

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

    private fun bannerRetrofit() {
        val call: Call<ResponseBanner> = ServiceCreator.mainService.getBanner()

        call.enqueue(object : Callback<ResponseBanner>{
            override fun onResponse(
                call: Call<ResponseBanner>,
                response: Response<ResponseBanner>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

//                    Glide.with(this)
//                        .load(data?.image)
//                        .placeholder(R.drawable.card_img)
//                        .into(binding.cardImg)

                }
                else {
                }
            }

            override fun onFailure(call: Call<ResponseBanner>, t: Throwable) {
                Log.d("NetworkTest_banner","error:$t")
            }
        })
    }
}