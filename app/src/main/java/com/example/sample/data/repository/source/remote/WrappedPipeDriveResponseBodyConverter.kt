package com.example.sample.data.repository.source.remote

import com.example.sample.data.PipeDriveResponse
import okhttp3.ResponseBody
import retrofit2.Converter


class WrappedPipeDriveResponseBodyConverter<T>(
        private val converter: Converter<ResponseBody, PipeDriveResponse<T>>
) : Converter<ResponseBody, T> {

    override fun convert(value: ResponseBody): T? {
        val response = converter.convert(value)
        return if (response.success) response?.data else throw CommunicateException(response?.error)
    }
}