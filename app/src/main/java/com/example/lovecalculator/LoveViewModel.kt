package com.example.lovecalculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lovecalculator.model.LoveModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    fun getLoveLiveData(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getData(firstName,secondName)

    }

}