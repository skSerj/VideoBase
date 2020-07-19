package com.videobase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.videobase.network.Coroutines
import com.videobase.network.ShowsRepository
import com.videobase.network.model.ShowsModel
import kotlinx.coroutines.Job

class ShowsViewModel(
    private val repository: ShowsRepository
) : ViewModel() {
    private lateinit var job: Job

    private val _shows = MutableLiveData<List<ShowsModel>>()
    val shows: LiveData<List<ShowsModel>>
        get() = _shows

    fun getShows() {
        job = Coroutines.ioThenMain(
            { repository.getShows() },
            { _shows.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}