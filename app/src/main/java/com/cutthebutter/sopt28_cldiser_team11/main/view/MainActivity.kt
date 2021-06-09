package com.cutthebutter.sopt28_cldiser_team11.main.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.api.ServiceCreator
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityMainBinding
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseBannerData
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseFoodCategory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fragmentSetting()
//        MainBannerRetrofit()


    }

    private fun fragmentSetting(){
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

    private fun MainBannerRetrofit(){
        val call : Call<ResponseBannerData> = ServiceCreator.mainService.getMainBanner()

        call.enqueue(object : Callback<ResponseBannerData>{
            override fun onResponse(
                call: Call<ResponseBannerData>,
                response: Response<ResponseBannerData>
            ) {
                if (response.isSuccessful){
                    val data = response.body()?.data
                    //todo
                }else{
                    //todo
                }
            }

            override fun onFailure(call: Call<ResponseBannerData>, t: Throwable) {
                Log.d("NetworkTest_Banner", "error:$t")
            }
        })
    }


}