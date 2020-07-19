package com.videobase.network

class ShowsRepository(private val api: ShowApi) : SafeApiRequest() {
    suspend fun getShows() = apiRequest { api.getShows() }
}