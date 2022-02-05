package com.example.translators.proffDev.data.api

import android.util.Log
import com.example.translators.proffDev.data.api.ApiConstants.BASE_URL
import com.example.translators.proffDev.data.model.DataModelResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface TranslatorApi {
    @GET("words/search")
    fun searchAsync(@Query("search") wordToSearch: String): Deferred<List<DataModelResponse>>

    companion object {

        fun create(): TranslatorApi =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(createOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()
                .create(TranslatorApi::class.java)

        private fun createOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        private val httpLoggingInterceptor: HttpLoggingInterceptor
            get() = HttpLoggingInterceptor { message ->
                Log.i("Network", message)
            }.apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
    }
}