package com.example.sample.data.repository.source.local


import com.example.sample.data.ContactModel
import com.example.sample.data.repository.PipeDriveSource
import com.example.sample.data.repository.database.PipeDriveDao

import javax.inject.Inject
import javax.inject.Singleton

import io.reactivex.Flowable

@Singleton
class LocalConnection @Inject
constructor(private val mContactsDao: PipeDriveDao) : PipeDriveSource {

    override fun getContacts(): Flowable<List<ContactModel>> {
        return mContactsDao.getContacts()
    }

    override fun addContact(contacts: List<ContactModel>) {
        mContactsDao.insertContacts(contacts)
    }

}
