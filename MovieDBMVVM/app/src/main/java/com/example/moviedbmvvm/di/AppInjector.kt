package com.example.moviedbmvvm.di

import android.content.SharedPreferences
import com.example.moviedbmvvm.data.api.ApiClient
import com.example.moviedbmvvm.data.repository.MovieListDataStore
import com.example.moviedbmvvm.domain.GetMovieListUseCase
import com.example.moviedbmvvm.domain.MovieListRepository
import com.example.moviedbmvvm.viewmodel.MovieListViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module



val viewModeModule = module{
    viewModel { MovieListViewModel(get( )) }
}

val useCaseModule = module{
    single { GetMovieListUseCase(get<MovieListDataStore>()) }
}

val repositoryModule = module{
    single { MovieListDataStore(get()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get())}
}

val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("default", android.content.Context.MODE_PRIVATE)
            .edit()
    }
}