package com.example.sample.di

import android.arch.persistence.room.Room
import android.content.Context
import com.example.sample.BuildConfig
import com.example.sample.data.repository.PipeDriveRepository
import com.example.sample.data.repository.database.PipeDriveDB
import com.example.sample.data.repository.database.PipeDriveDao
import com.example.sample.data.repository.source.local.LocalConnection
import com.example.sample.data.repository.source.remote.RemoteConnection
import com.example.sample.data.repository.source.remote.RemoteService
import com.example.sample.data.repository.source.remote.UnWrappedConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Named("BASEURL")
    internal fun provideBaseUrl(): String {
        return BuildConfig.SERVER_URL
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(@Named("BASEURL") baseUrl: String, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(UnWrappedConverterFactory(GsonConverterFactory.create()))
                .build()
    }

    @Provides
    @Singleton
    internal fun provideService(retrofit: Retrofit): RemoteService {
        return retrofit.create(RemoteService::class.java)
    }

    @Provides
    @Singleton
    internal fun provideRemoteConnection(service: RemoteService): RemoteConnection {
        return RemoteConnection(service)
    }

    @Provides
    @Singleton
    internal fun provideDatabase(context: Context): PipeDriveDB {
        return Room.databaseBuilder(context, PipeDriveDB::class.java, "PipeDrive.db").build()
    }

    @Provides
    @Singleton
    internal fun providePipeDriveDao(roomConnection: PipeDriveDB): PipeDriveDao {
        return roomConnection.pipeDriveDao()
    }

    @Provides
    @Singleton
    internal fun provideLocalConnection(pipeDriveDao: PipeDriveDao): LocalConnection {
        return LocalConnection(pipeDriveDao)
    }

    @Provides
    @Singleton
    internal fun provideContactsShowRepository(remote: RemoteConnection, local: LocalConnection): PipeDriveRepository {
        return PipeDriveRepository(remote, local)
    }

}
