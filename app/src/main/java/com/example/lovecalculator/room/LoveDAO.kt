package com.example.lovecalculator.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.lovecalculator.model.LoveModel

@Dao
interface LoveDAO {

    @Query("SELECT * FROM `love-table` ORDER BY  firstName ASC")
    fun getAll(): List<LoveModel>
    @Insert
    fun insert( model :LoveModel)
}