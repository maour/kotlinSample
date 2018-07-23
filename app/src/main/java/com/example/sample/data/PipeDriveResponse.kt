package com.example.sample.data


data class PipeDriveResponse<T>(
        val success: Boolean,
        val data: T?,
        val error: String?
)