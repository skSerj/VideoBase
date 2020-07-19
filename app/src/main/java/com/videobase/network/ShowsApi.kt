package com.videobase.network

import com.videobase.network.model.ShowsModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ShowsApi {

    @GET("shows")
    suspend fun getShows(): Response<List<ShowsModel>>

    companion object {
        operator fun invoke(): ShowsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.tvmaze.com/")
                .build()
                .create(ShowsApi::class.java)
        }
    }
}