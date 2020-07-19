package com.videobase.network

import com.videobase.network.model.RequestMovieModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ShowApi {

    @GET("shows")
    suspend fun getShows(): Response<List<RequestMovieModel>>

    companion object {
        operator fun invoke(): ShowApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.tvmaze.com/")
                .build()
                .create(ShowApi::class.java)
        }
    }
}