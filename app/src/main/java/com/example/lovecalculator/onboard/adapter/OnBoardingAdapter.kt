package com.example.lovecalculator.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.lovecalculator.R

import com.example.lovecalculator.databinding.ItemOnbordBinding
import com.example.lovecalculator.model.OnBoarding

class OnBoardingAdapter(private val onClick: () -> Unit):Adapter<OnBoardingAdapter.Holder>() {
    private val list = arrayListOf<OnBoarding>(
     OnBoarding(R.raw.hart1,"У всех ли есть своя полавина \n " +
        "И как узнать твоя это половина?"),
        OnBoarding(R.raw.hart2,"Введите его имя\n" +
                " Потом свое имя"),
        OnBoarding(R.raw.hart4,"Нажмите на кнопку "),
        OnBoarding(R.raw.hart3,"Вот и результат ураа")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
     return Holder(ItemOnbordBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int=list.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }
    inner class Holder(private var binding: ItemOnbordBinding):ViewHolder(binding.root){

        fun bind(onBoarding: OnBoarding){
            binding.apply {
                onBoarding.apply {
                    title.text = name
                    next.isVisible = adapterPosition == list.lastIndex
                    skip.isVisible = adapterPosition != list.lastIndex
                    onBoarding.image?.let { binding.ivBoard.setAnimation(it) }
                    next.setOnClickListener { onClick() }
                    skip.setOnClickListener { onClick() }
                }
            }

        }
    }
}