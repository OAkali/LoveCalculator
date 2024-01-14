package com.example.lovecalculator.onboard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.lovecalculator.databinding.ItemOnbordBinding
import com.example.lovecalculator.model.OnBoarding
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

class OnBoardingAdapter(private val onClick: () -> Unit):Adapter<OnBoardingAdapter.Holder>() {
    private val list = arrayListOf<OnBoarding>(
OnBoarding("https://i.postimg.cc/hP7ny59n/photo-5269554938525112354-x.jpg","У всех ли есть своя полавина \n " +
        "И как узнать твоя это половина?"),
        OnBoarding("https://i.postimg.cc/255LZYZm/photo-5269554938525112330-y.jpg","Введите его имя\n" +
                " Потом свое имя"),
        OnBoarding("https://i.postimg.cc/dVsLbFnd/photo-5269554938525112327-y.jpg","Нажмите на кнопку "),
        OnBoarding("https://i.postimg.cc/fyYVNT67/photo-5269554938525112329-y.jpg","Вот и результат ураа")
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
                    Glide.with(ivBoard).load(image)
                        .into(ivBoard)
                    next.setOnClickListener { onClick() }
                    skip.setOnClickListener { onClick() }
                }
            }

        }
    }
}