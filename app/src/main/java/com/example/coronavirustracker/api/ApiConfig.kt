package com.example.coronavirustracker.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        fun getApiService(): ApiService {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://data.covid19.go.id/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }

        fun getApiService2(): ApiService {
            val loggingInterceptor2 =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            val client2 = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor2)
                .build()
            val retrofit2 = Retrofit.Builder()
                .baseUrl("https://dekontaminasi.com/api/id/covid19/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client2)
                .build()
            return retrofit2.create(ApiService::class.java)
        }
    }
}