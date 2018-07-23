package com.example.sample.data.repository.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

import com.example.sample.data.Constants
import com.example.sample.data.ContactModel

import io.reactivex.Flowable

@Dao
interface PipeDriveDao {

    @Query("SELECT * FROM " + Constants.CONTACTS_TABLE_NAME)
    fun getContacts(): Flowable<List<ContactModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContacts(contacts: List<ContactModel>)

}
