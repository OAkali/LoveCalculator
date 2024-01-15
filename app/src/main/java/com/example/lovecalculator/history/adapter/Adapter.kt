package com.example.lovecalculator.history.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.databinding.ItemHistoryBinding
import com.example.lovecalculator.model.LoveModel

class Adapter:RecyclerView.Adapter<Adapter.Holder>() {

    private  val list= arrayListOf<LoveModel>()
    fun addTasks(lists: LoveModel) {
        list.addAll(listOf(lists))
        notifyDataSetChanged()
    }
    inner class Holder(private val binding:ItemHistoryBinding):ViewHolder(binding.root){
        fun bind(model:LoveModel){
            binding.apply {
                history.text=model.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
     return Holder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()=list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

}