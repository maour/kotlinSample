package com.example.sample.data.repository.source.remote


import com.example.sample.data.ContactModel

import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteService {

    @GET("persons")
    fun getContacts(
            @Query("api_token") apiToken: String
    ): Flowable<List<ContactModel>>
}
