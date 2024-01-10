package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.lovecalculator.model.LoveModel

class LoveViewModel : ViewModel() {
    private val repository = Repository()
    fun getLoveLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName,secondName)

    }
}