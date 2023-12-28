package com.example.lovecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showResult()
    }

    private fun showResult() {
       binding.apply {
           resulttv.text= intent.getStringExtra(MainActivity.KEY_RESULT)
        }
    }
}