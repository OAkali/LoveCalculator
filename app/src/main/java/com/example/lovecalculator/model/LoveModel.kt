package com.example.lovecalculator.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "love-table")
data class LoveModel(
    @SerializedName("fname")
    val firstName:String,
    @SerializedName("sname")
    val secondName:String,
    val percentage: String,
    val result:String,
    @PrimaryKey(autoGenerate = true)
    var id:Int=1
){
    override fun toString ():String{
        return "$id\n$firstName\n$secondName\n$percentage\n$result\n"
    }
}
