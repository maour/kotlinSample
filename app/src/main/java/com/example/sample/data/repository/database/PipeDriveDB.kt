package com.example.sample.data.repository.database


import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import com.example.sample.data.ContactModel


@Database(entities = [(ContactModel::class)], version = 1, exportSchema = false)
abstract class PipeDriveDB : RoomDatabase() {

    abstract fun pipeDriveDao(): PipeDriveDao

}
