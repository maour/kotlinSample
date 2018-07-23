package com.example.sample.data.repository.source.remote


import com.example.sample.BuildConfig
import com.example.sample.data.ContactModel
import com.example.sample.data.repository.PipeDriveSource

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Flowable

@Singleton
class RemoteConnection @Inject
constructor(private val mService: RemoteService) : PipeDriveSource {

    override fun getContacts(): Flowable<List<ContactModel>> {
        return Flowable.empty()
    }

    override fun addContact(contacts: List<ContactModel>) {
        //Handled on LocalDatabase
    }

    fun fetchContacts(): Flowable<List<ContactModel>> {
        return mService.getContacts(BuildConfig.API_TOKEN)
    }
}
