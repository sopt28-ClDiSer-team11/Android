package com.cutthebutter.sopt28_cldiser_team11.main.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentPickingRestaurantBinding
import com.cutthebutter.sopt28_cldiser_team11.main.data.PickingRestaurantData
import com.cutthebutter.sopt28_cldiser_team11.main.adapter.PickingRestaurantAdapter

class PickingRestaurantFragment : Fragment() {

    private var _binding: FragmentPickingRestaurantBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기위해 binding이 초기화되지 않았습니다.")

    private lateinit var pickingRestaurantAdapter: PickingRestaurantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPickingRestaurantBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        pickingRestaurantAdapter = PickingRestaurantAdapter()
        binding.pickingRestaurant.adapter = pickingRestaurantAdapter
        binding.pickingRestaurant.layoutManager = LinearLayoutManager(requireContext()).also {
            it.orientation = LinearLayoutManager.HORIZONTAL
        }

        pickingRestaurantAdapter.pickingRestaurantDatas.addAll(
            listOf<PickingRestaurantData>(
                PickingRestaurantData(
                    picking_img = R.drawable.picking_img_1,
                    picking_title = "라라레스토랑",
                    star_point = "4.8",
                    grade_amount = "705",
                    distance = "0.4"
                ),
                PickingRestaurantData(
                    picking_img = R.drawable.picking_img_2,
                    picking_title = "나폴로피자",
                    star_point = "4.7",
                    grade_amount = "700",
                    distance = "0.5"
                ),
                PickingRestaurantData(
                    picking_img = R.drawable.picking_img_1,
                    picking_title = "퀸수제버거",
                    star_point = "4.9",
                    grade_amount = "715",
                    distance = "0.6"
                ),

                )
        )
        pickingRestaurantAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}