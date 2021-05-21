package com.cutthebutter.sopt28_cldiser_team11.inner

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cutthebutter.sopt28_cldiser_team11.databinding.FragmentMenuBinding


class MenuFragment:Fragment() {

    private var _binding : FragmentMenuBinding? =null
    private val binding get() = _binding?: error("View를 참조하기 위해 binding이 초기화 되지 않았습니다.")
    private lateinit var menuAdapter: MenuAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        menuAdapter = MenuAdapter()
        binding.menuList.adapter = menuAdapter


        menuAdapter.menuList.addAll(
            listOf<MenuData>(
                MenuData(
                    menu_title = "모듬초밥 12P",
                    menu_price = "12,000",
                    menu_detail = "연어2, 활어2, 참치2, 찐새우2, 계란2"
                ),
                MenuData(
                    menu_title = "스페셜 초밥 14P",
                    menu_price = "15,000",
                    menu_detail = "연어2, 활어2, 참치2, 찐새우2, 장어4"
                ),
                MenuData(
                    menu_title = "연어 초밥 12P",
                    menu_price = "11,000",
                    menu_detail = "연어12"
                )

            )
        )

        menuAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}