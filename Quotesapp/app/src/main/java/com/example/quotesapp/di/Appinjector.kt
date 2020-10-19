package com.example.quotesapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.quotesapp.data.api.ApiClient
import com.example.quotesapp.data.repository.QuoteListDataStore
import com.example.quotesapp.domain.GetQuoteListUseCase
import com.example.quotesapp.viewModel.QuotesListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModeModule = module{
    viewModel { QuotesListViewModel(get( )) }
}

val useCaseModule = module{
    single { GetQuoteListUseCase(get<QuoteListDataStore>()) }
}

val repositoryModule = module{
    single { QuoteListDataStore(get()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get())}
}

val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", Context.MODE_PRIVATE)
            .edit()
    }
}