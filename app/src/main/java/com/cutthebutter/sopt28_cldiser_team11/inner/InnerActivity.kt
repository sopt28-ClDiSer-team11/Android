package com.cutthebutter.sopt28_cldiser_team11.inner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ScrollView
import com.bumptech.glide.Glide
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.api.ServiceCreator
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityInnerBinding
import com.cutthebutter.sopt28_cldiser_team11.inner.model.ResponseMenu
import com.cutthebutter.sopt28_cldiser_team11.inner.model.ResponseRestaurantDetail
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import com.cutthebutter.sopt28_cldiser_team11.main.view.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInnerBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBackButton()
        restaurantDetailRetrofit()

        val menuFragment = MenuFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.menu_frag, menuFragment)
        transaction.commit()

//        binding.scrollView.post {
//            binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
//        }

    }

    private fun initBackButton(){
        binding.iconArrowBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun restaurantDetailRetrofit() {
        val call: Call<ResponseRestaurantDetail> = ServiceCreator.mainService.getRestaurantDetail("1")

        call.enqueue(object : Callback<ResponseRestaurantDetail> {
            override fun onResponse(
                call: Call<ResponseRestaurantDetail>,
                response: Response<ResponseRestaurantDetail>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    with(binding){
                        restaurantMainTitle.text = data?.title
                        restaurantMainPoint.text = data?.star
                        restaurantReviewCount.text = data?.review
                        timeText.text = data?.minute
                        deliveryCost.text = data?.fee
                        miniOrderCost.text = data?.minimumPrice
                        noticeText.text = data?.notice
                    }

                } else {

                }
            }

            override fun onFailure(call: Call<ResponseRestaurantDetail>, t: Throwable) {
                Log.d("NetworkTest_menu", "error:$t")
            }
        })
    }

}