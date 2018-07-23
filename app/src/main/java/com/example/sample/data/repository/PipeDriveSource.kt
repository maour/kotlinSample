package com.example.sample.data.repository


import com.example.sample.data.ContactModel

import io.reactivex.Flowable

interface PipeDriveSource {

    fun getContacts(): Flowable<List<ContactModel>>

    fun addContact(contacts: List<ContactModel>)

}
