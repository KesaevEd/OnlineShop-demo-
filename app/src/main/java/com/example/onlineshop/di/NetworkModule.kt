package com.example.onlineshop.di

import com.example.onlineshop.core.data.network.ShopApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideOkHttpClient(
    ): OkHttpClient =
        OkHttpClient().newBuilder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json; charset=utf-8")
                    .build()
                val response = chain.proceed(request)
                response
            }
            .build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun provideShopApi(retrofit: Retrofit): ShopApi =
        retrofit.create(ShopApi::class.java)


    private companion object {
        private const val BASE_URL = "https://run.mocky.io"
    }
}