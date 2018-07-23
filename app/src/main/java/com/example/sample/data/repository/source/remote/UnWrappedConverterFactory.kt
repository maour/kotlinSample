package com.example.sample.data.repository.source.remote

import com.example.sample.data.PipeDriveResponse
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class UnWrappedConverterFactory(
        private var factory: GsonConverterFactory)
    : Converter.Factory() {

    override
    fun responseBodyConverter(type: Type?, annotations: Array<out Annotation>?, retrofit: Retrofit?)
            : Converter<ResponseBody, *>? {
        val wrappedType: Type = object : ParameterizedType {

            override fun getRawType(): Type = PipeDriveResponse::class.java

            override fun getOwnerType(): Type? = null

            override fun getActualTypeArguments(): Array<Type?> = arrayOf(type)
        }

        val gsonConverter: Converter<ResponseBody, *>? = factory.responseBodyConverter(wrappedType, annotations, retrofit)
        return WrappedPipeDriveResponseBodyConverter(gsonConverter as Converter<ResponseBody, PipeDriveResponse<Any>>)
    }
}
