package com.videobase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.videobase.network.ShowsRepository

@Suppress("UNCHECKED_CAST")
class ShowsViewModelFactory(private val repository: ShowsRepository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShowsViewModel(repository) as T
    }
}
