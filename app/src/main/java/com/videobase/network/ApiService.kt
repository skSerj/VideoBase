package com.videobase.network

import com.videobase.network.model.RequestMovieModel
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object ApiService {
    private const val END_POINT = "http://api.tvmaze.com/"

    private val movieApi: MovieApi

    suspend fun getShowList() = movieApi.popularMovies()

    interface MovieApi {
        @GET("shows")
        suspend fun popularMovies(): Response<List<RequestMovieModel>>
    }

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client =
            OkHttpClient.Builder().addInterceptor(interceptor).build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(END_POINT)
            .client(client)
            .build()
        movieApi = retrofit.create(MovieApi::class.java)
    }
}