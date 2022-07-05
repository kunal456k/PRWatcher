package com.kunal456k.prwatcher.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.kunal456k.prwatcher.Constants
import com.kunal456k.prwatcher.InstantConverter
import com.kunal456k.prwatcher.services.PRApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.Instant
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson() : Gson{
        val gsonBuilder =  GsonBuilder()
        gsonBuilder.registerTypeAdapter(object :TypeToken<Instant>() {}.type, InstantConverter())
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient{
        val client = OkHttpClient.Builder()
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient) : Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.GITHUB_API_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun providePRApi(retrofit: Retrofit) : PRApi{
        return retrofit.create(PRApi :: class.java)
    }
}