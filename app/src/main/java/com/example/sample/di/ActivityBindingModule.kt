package com.example.sample.di


import com.example.sample.ContactsListActivity

import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.ContributesAndroidInjector

@Module(includes = [(AndroidInjectionModule::class)])
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector()
    internal abstract fun contactsListActivity(): ContactsListActivity

}