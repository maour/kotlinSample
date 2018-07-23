package com.example.sample.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.sample.data.repository.PipeDriveRepository
import javax.inject.Inject


class ContactsListViewModelFactory @Inject constructor(val repository: PipeDriveRepository)
    : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContactsListViewModel(repository) as T
    }

}