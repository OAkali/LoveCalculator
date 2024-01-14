package com.example.lovecalculator

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi) {
    fun getData(firstName:String , secondName:String):MutableLiveData<LoveModel>{
        val mutableLiveData=MutableLiveData<LoveModel>()
        api.getLovePerc(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    response.body()?.let {loveModel->
                        mutableLiveData.postValue(loveModel)
                    }
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
              Log.e("ololo","onF: ${t.message}")
            }
        })
        return mutableLiveData
    }
}