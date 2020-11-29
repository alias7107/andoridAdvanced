package com.example.quotesapp.data.api

import com.example.quotesapp.data.model.QuoteResponse
import com.example.quotesapp.data.model.TypeHeadResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import com.example.quotesapp.BR
import com.example.quotesapp.data.model.Tags

interface ApiService {
//    @Headers(
//        "Content-Type: application/json",
//        "Authorization: Token token=3076049eda9ba452981badda30fe2d47")
    @GET("quotes/")
    fun getQuotesList(@Query("filter") filter: String, @Query("type") type: String): Deferred<Response<QuoteResponse>>

    @GET("quotes/")
    fun getSearchableQuotesList(@Query("filter") filter: String): Deferred<Response<QuoteResponse>>

    @GET("typeahead/")
    fun getTagsList(): Deferred<Response<TypeHeadResponse>>

}