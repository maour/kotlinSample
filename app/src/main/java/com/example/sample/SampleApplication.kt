package com.example.sample

import android.app.Activity
import com.example.sample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Inject


class SampleApplication : DaggerApplication() {

    @Inject
    lateinit var dispatchingActivityInjector: AndroidInjector<Activity>

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}