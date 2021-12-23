package com.noranekoit.bajp.moe.data.source.remote.network


import androidx.viewbinding.BuildConfig
import com.noranekoit.bajp.moe.BuildConfig.BASE_URL_TMDB
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        fun getApiService(): ApiService {
            val client = OkHttpClient.Builder()
            if (BuildConfig.DEBUG) {
                 val loggingInterceptor =
                     HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                     client.addInterceptor(loggingInterceptor)
                     .build()
            }
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL_TMDB)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}