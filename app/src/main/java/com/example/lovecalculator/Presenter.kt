package com.example.lovecalculator

import retrofit2.Callback
import com.example.lovecalculator.model.LoveModel
import com.example.lovecalculator.model.RetrofitService
import retrofit2.Call
import retrofit2.Response

class Presenter {
    val api = RetrofitService().api
    private lateinit var view: LoveView
    fun attachView(view: LoveView) {
        this.view = view
    }

    fun getDate(firstName: String, secondName: String) {
        api.getLovePerc(firstName, secondName).enqueue(object : Callback<LoveModel> {
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        view.intentResult(it)

                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                view.error(t.message.toString())
            }

        })
    }



}