package com.example.sample.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context


import com.example.sample.BuildConfig
import com.example.sample.data.repository.PipeDriveRepository
import com.example.sample.data.repository.database.PipeDriveDao
import com.example.sample.data.repository.database.PipeDriveDB
import com.example.sample.data.repository.source.local.LocalConnection
import com.example.sample.data.repository.source.remote.RemoteConnection
import com.example.sample.data.repository.source.remote.RemoteService
import com.example.sample.data.repository.source.remote.UnWrappedConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

import javax.inject.Named
import javax.inject.Singleton

import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
abstract class ContextModule {

    @Binds
    @Singleton
    internal abstract fun bindContext(application: Application): Context

}