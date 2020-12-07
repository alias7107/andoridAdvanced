package com.example.quotesapp

import android.app.Application
import com.example.quotesapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@MainApplication)
            koin.loadModules(listOf(viewModeModule, SignInViewModeModule, SignInUseCaseModule, SignInRepositoryModule, TagsViewModeModule, TagsUseCaseModule, useCaseModule, TagsRepositoryModule, repositoryModule, networkModule, sharedPrefModule))
            koin.createRootScope()
        }
    }

}
//TagsViewModeModule, TagsUseCaseModule,  TagsRepositoryModule, TagsNetworkModule, TagsSharedPrefModule,