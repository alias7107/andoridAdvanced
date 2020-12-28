package com.example.quotesapp.di

import android.content.Context
import android.content.SharedPreferences
import com.example.quotesapp.R
import com.example.quotesapp.data.api.ApiClient
import com.example.quotesapp.data.api.SessionManager.Companion.USER_TOKEN
import com.example.quotesapp.data.repository.*
import com.example.quotesapp.domain.*
import com.example.quotesapp.viewModel.*
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModeModule = module{
    viewModel { QuotesListViewModel(get( ))

    }
    viewModel { UserProfileViewModel(get( ))

    }
    viewModel { PostQuoteViewModel(get( ))

    }
    viewModel { TagsListViewModel(get<GetTagsListUseCase>()) }


}

val SignInViewModeModule = module{
    viewModel {SignInViewModel(get())
    }
}

val useCaseModule = module{

    single { GetQuoteListUseCase(get<QuoteListDataStore>())

    }
    single { GetUserProfileUseCase(get<UserProfileDataStore>())

    }
    single { PostQuoteUseCase(get<PostQuoteDataStore>())

    }
    single { GetTagsListUseCase(get<TagsListDataStore>()) }

}

val SignInUseCaseModule = module{
    single {
        LoginUseCase(get<LoginDataStore>())
    }
    }



val repositoryModule = module{
    single { QuoteListDataStore(get())
        }
    single { UserProfileDataStore(get())
    }
    single { PostQuoteDataStore(get())
    }
    single { TagsListDataStore(get(), androidApplication()) }
    }




val SignInRepositoryModule = module {
    single {
        LoginDataStore(get(), androidApplication())

    }
}

val networkModule = module {
    single { ApiClient.create(okHttpClient = get()) }
    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
    single { ApiClient.getAuthInterceptor(sharedPreferences = get())}
}

val sharedPrefModule = module {
    single {
        androidApplication().getSharedPreferences("Login", Context.MODE_PRIVATE)
    }

    single<SharedPreferences.Editor> {
        androidApplication().getSharedPreferences("Login", Context.MODE_PRIVATE)
            .edit()
    }
}