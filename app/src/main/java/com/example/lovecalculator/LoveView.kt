package com.example.lovecalculator

import com.example.lovecalculator.model.LoveModel
import java.lang.Error

interface LoveView {
    fun intentResult(model: LoveModel)
    fun error(error: String)
}