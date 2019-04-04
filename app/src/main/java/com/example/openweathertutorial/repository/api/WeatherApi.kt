package com.example.openweathertutorial.repository.api

import android.util.Log
import com.example.openweathertutorial.repository.db.data.Weather
import io.reactivex.Observable
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    fun getWeather(@Query("q") cityName:String) : Observable<List<Weather>>

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"
        fun create(): WeatherApi = create(HttpUrl.parse(BASE_URL)!!)
        fun create(httpUrl: HttpUrl): WeatherApi{

            val authInterceptor = Interceptor {chain ->
                val newUrl = chain.request().url()
                    .newBuilder()
                    .addQueryParameter("appid", "ab2e88601b4943b3021219d4b80079f1")
                    .build()

                val newRequest = chain.request()
                    .newBuilder()
                    .url(newUrl)
                    .build()
                chain.proceed(newRequest)
            }

            val logger = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                Log.d("API",it)

            })
            logger.level = HttpLoggingInterceptor.Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .addInterceptor(authInterceptor)
                .build()

            return Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                
                .build()
                .create(WeatherApi::class.java)
        }
    }
}