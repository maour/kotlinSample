package com.example.sample.data.repository


import android.annotation.SuppressLint
import com.example.sample.data.ContactModel
import com.example.sample.data.repository.source.local.LocalConnection
import com.example.sample.data.repository.source.remote.RemoteConnection
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PipeDriveRepository @Inject
constructor(private val mRemote: RemoteConnection, private val mLocal: LocalConnection) : PipeDriveSource {

    override fun getContacts(): Flowable<List<ContactModel>> {
        reloadContactsData()

        return mLocal.getContacts()
    }

    override fun addContact(contacts: List<ContactModel>) {
        mLocal.addContact(contacts)
    }

    @SuppressLint("CheckResult")
    private fun reloadContactsData() {
        mRemote.fetchContacts()
                .subscribeOn(Schedulers.io())
                .subscribe({ contacts ->
                    storeOnDB(contacts)
                }, {
                    it.printStackTrace()
                })

    }

    private fun storeOnDB(responseList: List<ContactModel>) {
        mLocal.addContact(responseList)
    }

    companion object {
        private val TAG = "Repository"
    }
}
