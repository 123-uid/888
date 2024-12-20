package com.example.a1base.ulits

import com.zyj.retrofit.adapter.FlowCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitUlits {

    fun retrofit(): Retrofit {
        val okHttpClient =OkHttpClient.Builder()
            .build()
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://dev.usemock.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(FlowCallAdapterFactory.create())
            .build()
        return retrofit
    }

}