package com.example.lovecalculator.history

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lovecalculator.App
import com.example.lovecalculator.databinding.ActivityHistoryBinding
import com.example.lovecalculator.history.adapter.Adapter

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private val adapter = Adapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = App.appDatabase.getDao().getAll()
        list.forEach {
            binding.rvhom.adapter=adapter
            adapter.addTasks(it)
        }


    }


}
