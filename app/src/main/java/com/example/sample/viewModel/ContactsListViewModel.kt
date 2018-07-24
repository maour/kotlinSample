package com.example.sample.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sample.data.ContactModel
import com.example.sample.data.repository.PipeDriveRepository
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class ContactsListViewModel @Inject constructor(private val mRepository: PipeDriveRepository)
    : ViewModel() {

    private val personsListResponse = MutableLiveData<List<ContactModel>>()

    private val disposable by lazy { CompositeDisposable() }

    fun personsListResponse(): MutableLiveData<List<ContactModel>> {
        return personsListResponse
    }

    fun loadContacts() {
        disposable.add(mRepository.getContacts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    personsListResponse.value = it
                }, { e ->
                    e.printStackTrace()
                }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
        disposable.dispose()

    }

}