package com.cutthebutter.sopt28_cldiser_team11.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cutthebutter.sopt28_cldiser_team11.api.ServiceCreator
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentRecentPickingRestaurantBinding
import com.cutthebutter.sopt28_cldiser_team11.main.adapter.Recent_PickingRestaurantAdapter
import com.cutthebutter.sopt28_cldiser_team11.main.model.ResponseRecentRestaurant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Recent_PickingRestaurantFragment : Fragment() {

    private var _binding: FragmentRecentPickingRestaurantBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기위해 binding이 초기화되지 않았습니다.")

    private lateinit var recentpickingRestaurantAdapter: Recent_PickingRestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecentPickingRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recentpickingRestaurantAdapter = Recent_PickingRestaurantAdapter()
        binding.recentPickingRestaurant.adapter = recentpickingRestaurantAdapter
        binding.recentPickingRestaurant.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        RecentPickingRestaurantRetrofit()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun RecentPickingRestaurantRetrofit() {
        val call: Call<ResponseRecentRestaurant> = ServiceCreator.mainService.getRecentRestaurant()

        call.enqueue(object : Callback<ResponseRecentRestaurant> {
            override fun onResponse(
                call: Call<ResponseRecentRestaurant>,
                response: Response<ResponseRecentRestaurant>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()?.data
                    //todo
                    recentpickingRestaurantAdapter.RecentpickingRestaurantDatas.addAll(requireNotNull(data))
                    recentpickingRestaurantAdapter.notifyDataSetChanged()

                } else {

                }

            }

            override fun onFailure(call: Call<ResponseRecentRestaurant>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}