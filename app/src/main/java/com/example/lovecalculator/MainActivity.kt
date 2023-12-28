package com.example.lovecalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.model.LoveModel

class MainActivity : AppCompatActivity(), LoveView {
    private lateinit var binding: ActivityMainBinding
    private val prisenter = Presenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prisenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            getBtn.setOnClickListener {

                prisenter.getDate(firstEd.text.toString(), secondEd.text.toString())
            }
        }
    }


    override fun intentResult(model: LoveModel) {
        val intent = Intent(this, ResultActivity::class.java)
         intent.putExtra(KEY_RESULT, "${model.result}\n${model.percentage}\n${model.firstName}\n${model.secondName}")
        startActivity(intent)
    }

    override fun error(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    companion object {
        const val KEY_RESULT = "key.madel"
    }
}