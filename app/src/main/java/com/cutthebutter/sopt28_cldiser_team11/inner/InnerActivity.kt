package com.cutthebutter.sopt28_cldiser_team11.inner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import com.cutthebutter.sopt28_cldiser_team11.R
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityInnerBinding

class InnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInnerBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val menuFragment = MenuFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.menu_frag, menuFragment)
        transaction.commit()

//        binding.scrollView.post {
//            binding.scrollView.fullScroll(ScrollView.FOCUS_UP)
//        }

    }


}