package com.cutthebutter.sopt28_cldiser_team11.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentFoodKindSectionBinding


class FoodKindSectionFragment : Fragment() {
    private var _binding: FragmentFoodKindSectionBinding? = null
    private val binding get() = _binding ?: error("View를 참조하기위해 binding이 초기화되지 않았습니다.")

    private lateinit var foodKindAdapter: FoodKindAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFoodKindSectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        foodKindAdapter = FoodKindAdapter()
        binding.foodKind.adapter = foodKindAdapter
        binding.foodKind.layoutManager = GridLayoutManager(requireContext(),5)

        foodKindAdapter.foodKindDatas.addAll(
            listOf<FoodKindData>(
                FoodKindData(
                    foodImage = R.drawable.category_img_1,
                    foodName = "신규 맛집"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_2,
                    foodName = "1인분"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_3,
                    foodName = "한식"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_4,
                    foodName = "치킨"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_5,
                    foodName = "분식"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_6,
                    foodName = "선물하기"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_7,
                    foodName = "중국집"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_8,
                    foodName = "버거"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_9,
                    foodName = "찜/탕"
                ),
                FoodKindData(
                    foodImage = R.drawable.category_img_10,
                    foodName = "일식"
                )
            )
        )
        foodKindAdapter.notifyDataSetChanged()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}