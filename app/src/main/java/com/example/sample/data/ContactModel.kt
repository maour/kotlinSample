package com.example.sample.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable

@Entity(tableName = Constants.CONTACTS_TABLE_NAME)
data class ContactModel(
        @PrimaryKey val id: String,
        val name: String?,
        val firstName: String?,
        val lastName: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            writeString(id)
            writeString(name)
            writeString(firstName)
            writeString(lastName)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ContactModel> {
        override fun createFromParcel(parcel: Parcel): ContactModel {
            return ContactModel(parcel)
        }

        override fun newArray(size: Int): Array<ContactModel?> {
            return arrayOfNulls(size)
        }
    }
}