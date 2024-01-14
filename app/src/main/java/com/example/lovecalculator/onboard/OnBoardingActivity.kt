package com.example.lovecalculator.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator.MainActivity
import com.example.lovecalculator.dl.local.Pref
import com.example.lovecalculator.databinding.ActivityOnBoardingBinding
import com.example.lovecalculator.onboard.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardingBinding
    private val adapter = OnBoardingAdapter(this::onClick)

    @Inject
    lateinit var pref: Pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ViewPager2.adapter = adapter
        binding.indicator.setViewPager(binding.ViewPager2)
    }


    private fun onClick() {
       pref.setOnBoardingComplete()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}