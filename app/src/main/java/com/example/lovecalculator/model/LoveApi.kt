package com.example.lovecalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLovePerc(
        @Query("fname") firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidApi-Key")key:String="78bb8ecc8dmsha71f7db1db6c66cp1338f5jsn2ae3a25d70d2",
        @Header("X-RapidAPI-Host")host:String="love-calculator.p.rapidapi.com"
    ): Call<LoveModel>
}