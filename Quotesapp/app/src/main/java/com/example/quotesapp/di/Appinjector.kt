package com.example.quotesapp.di

import com.example.quotesapp.data.api.ApiClient
import com.example.quotesapp.data.api.SessionManager
import com.example.quotesapp.data.repository.DataStore.*
import com.example.quotesapp.domain.UseCase.*
import com.example.quotesapp.viewModel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModeModule = module{
    viewModel { QuotesListViewModel(get( ), get()) }
    viewModel { UserProfileViewModel(get( )) }
    viewModel { PostQuoteViewModel(get( )) }
    viewModel { TagsListViewModel(get()) }
    viewModel { QuoteDetailViewModel(get()) }
}


val SignInViewModeModule = module{
    viewModel { SignInViewModel(get()) }
}


val useCaseModule = module{
    single { GetQuoteListUseCase(get<QuoteListDataStore>()) }
    single { GetUserProfileUseCase(get<UserProfileDataStore>()) }
    single { PostQuoteUseCase(get<PostQuoteDataStore>()) }
    single { GetTagsListUseCase(get<TagsListDataStore>()) }
    single { GetQuoteUseCase(get<QuoteDataStore>()) }
}


val SignInUseCaseModule = module{
    single { LoginUseCase(get<LoginDataStore>()) }
    }


val repositoryModule = module{
    single { QuoteListDataStore(get())
        }
    single { UserProfileDataStore(get())
    }
    single { PostQuoteDataStore(get())
    }
    single { TagsListDataStore(get(), androidApplication()) }
    single { QuoteDataStore(get()) }
    }


val SignInRepositoryModule = module {
    single { LoginDataStore(get(), androidApplication()) }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sessionManager = get<SessionManager>()) }
}

val sessionManagerModule = module {
    single { SessionManager(androidApplication()) }
}