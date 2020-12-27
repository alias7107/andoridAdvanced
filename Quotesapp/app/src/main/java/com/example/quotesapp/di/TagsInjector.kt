//package com.example.quotesapp.di
//
//import android.content.Context
//import android.content.SharedPreferences
//import com.example.quotesapp.data.api.ApiClient
//import com.example.quotesapp.data.repository.QuoteListDataStore
//import com.example.quotesapp.data.repository.TagsListDataStore
//import com.example.quotesapp.domain.GetQuoteListUseCase
//import com.example.quotesapp.domain.GetTagsListUseCase
//import com.example.quotesapp.viewModel.QuotesListViewModel
//import com.example.quotesapp.viewModel.TagsListViewModel
//import org.koin.android.ext.koin.androidApplication
//import org.koin.android.viewmodel.dsl.viewModel
//import org.koin.dsl.module
//
//val TagsViewModeModule = module{
//    viewModel { TagsListViewModel(get( )) }
//}
//
//val TagsUseCaseModule = module{
//    single { GetTagsListUseCase(get<TagsListDataStore>()) }
//}
//
//val TagsRepositoryModule = module{
//    single { TagsListDataStore(get()) }
//}
//
//val TagsNetworkModule = module {
//    single { ApiClient.create(okHttpClient = get()) }
//    single { ApiClient.getOkHttpClient(authInterceptor = get()) }
//    single { ApiClient.getAuthInterceptor(sharedPreferences = get())}
//}
//
//val TagsSharedPrefModule = module {
//    single {
//        androidApplication().getSharedPreferences("default", Context.MODE_PRIVATE)
//    }
//
//    single<SharedPreferences.Editor> {
//        androidApplication().getSharedPreferences("default", Context.MODE_PRIVATE)
//            .edit()
//    }
//}