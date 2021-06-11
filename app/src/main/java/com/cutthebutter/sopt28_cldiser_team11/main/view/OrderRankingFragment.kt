package com.cutthebutter.sopt28_cldiser_team11.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cutthebutter.sopt28_cldiser_team11.api.ServiceCreator
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentOrderRankingBinding
import com.cutthebutter.sopt28_cldiser_team11.main.adapter.OrderRankingAdapter
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderRankingFragment: Fragment() {

    private var _binding : FragmentOrderRankingBinding? =null
    private val binding get() = _binding?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다.")
    private lateinit var orderRankingAdapter: OrderRankingAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrderRankingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderRankingAdapter = OrderRankingAdapter()
        binding.rankingList.adapter = orderRankingAdapter
        binding.rankingList.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        OrderLankingRetrofit()
//        orderRankingAdapter.orderRankingList.addAll(
//            listOf<OrderRankingData>(
//                OrderRankingData(
//                    ranking_img = R.drawable.ranking_img_1,
//                    ranking_title = "라라레스토랑",
//                    star_point = "4.8",
//                    grade_amount = "705",
//                    distance = "0.4",
//                    delivery_time = "50~60"
//                ),
//                OrderRankingData(
//                    ranking_img = R.drawable.ranking_img_2,
//                    ranking_title = "그린샐러드바",
//                    star_point = "4.8",
//                    grade_amount = "705",
//                    distance = "0.4",
//                    delivery_time = "10~30"
//                )
//
//            )
//        )
//
//        orderRankingAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun OrderLankingRetrofit() {
        val call: Call<ResponseRecentRestaurant> = ServiceCreator.mainService.getRecentRestaurant()

        call.enqueue(object : Callback<ResponseRecentRestaurant> {
            override fun onResponse(
                call: Call<ResponseRecentRestaurant>,
                response: Response<ResponseRecentRestaurant>
            ) {
                if(response.isSuccessful) {
                    val data = response.body()?.data

                    orderRankingAdapter.orderRankingList.addAll(requireNotNull(data))
                    orderRankingAdapter.notifyDataSetChanged()
                }
                else {

                }
            }

            override fun onFailure(call: Call<ResponseRecentRestaurant>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}