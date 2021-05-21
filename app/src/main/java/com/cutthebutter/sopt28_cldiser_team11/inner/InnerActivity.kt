package com.cutthebutter.sopt28_cldiser_team11.inner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cutthebutter.sopt28_cldiser_team11.databinding.ActivityInnerBinding

class InnerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInnerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInnerBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}