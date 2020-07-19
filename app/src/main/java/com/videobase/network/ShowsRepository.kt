package com.videobase.network

class ShowsRepository(private val api: ShowsApi) : SafeApiRequest() {
    suspend fun getShows() = apiRequest { api.getShows() }
}