package com.example.lovecalculator.dl

import android.app.Application
import android.content.Context
import androidx.core.view.WindowInsetsCompat.Type.InsetsType
import com.example.lovecalculator.dl.local.Pref
import com.example.lovecalculator.model.LoveApi
import com.example.lovecalculator.onboard.adapter.OnBoardingAdapter
import com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }
    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providePref(context: Context):Pref {
        return Pref(context)

    }
}