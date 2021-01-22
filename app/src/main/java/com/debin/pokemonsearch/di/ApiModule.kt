package com.debin.pokemonsearch.di

import com.debin.pokemonsearch.framework.network.ApiService
import com.debin.pokemonsearch.framework.utils.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


var logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

var client = OkHttpClient.Builder()
    .addInterceptor(logging)
    .build()

val apiModule = module {
    fun provideApi() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(ApiService::class.java)
    }

single { provideApi() }
}