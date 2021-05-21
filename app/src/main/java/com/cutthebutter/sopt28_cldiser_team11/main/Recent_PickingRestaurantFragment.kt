package com.cutthebutter.sopt28_cldiser_team11.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentRecentPickingRestaurantBinding

class Recent_PickingRestaurantFragment : Fragment() {

    private var _binding: FragmentRecentPickingRestaurantBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기위해 binding이 초기화되지 않았습니다.")

    private lateinit var RecentpickingRestaurantAdapter: Recent_PickingRestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecentPickingRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        RecentpickingRestaurantAdapter = Recent_PickingRestaurantAdapter()
        binding.recentPickingRestaurant.adapter = RecentpickingRestaurantAdapter
        binding.recentPickingRestaurant.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        RecentpickingRestaurantAdapter.RecentpickingRestaurantDatas.addAll(
            listOf<Recent_PickingRestaurantData>(
                Recent_PickingRestaurantData(
                    recent_picking_img = R.drawable.picking_img_1,
                    recent_picking_title = "라라레스토랑",
                    star_score = "4.8",
                    grade_score = "705",
                    recent_distance = "0.4"
                ),
                Recent_PickingRestaurantData(
                    recent_picking_img = R.drawable.picking_img_2,
                    recent_picking_title = "나폴로피자",
                    star_score = "4.8",
                    grade_score = "705",
                    recent_distance = "0.4"
                ),
                Recent_PickingRestaurantData(
                    recent_picking_img = R.drawable.category_img_8,
                    recent_picking_title = "퀸수제버거",
                    star_score = "4.8",
                    grade_score = "705",
                    recent_distance = "0.4"
                ),

                )
        )
       RecentpickingRestaurantAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}