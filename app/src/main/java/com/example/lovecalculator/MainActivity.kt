package com.example.lovecalculator

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.lovecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel:LoveViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            getBtn.setOnClickListener {
                viewModel.getLoveLiveData(firstEd.text.toString(),secondEd.text.toString())
                    .observe(this@MainActivity, Observer {
                        val intent = Intent(this@MainActivity, ResultActivity::class.java)
                        intent.putExtra(KEY_RESULT, "${it.result}\n${it.percentage}\n${it.firstName}\n${it.secondName}")
                        startActivity(intent)
                    })
            }
        }
    }





    companion object {
        const val KEY_RESULT = "key.madel"
    }
}