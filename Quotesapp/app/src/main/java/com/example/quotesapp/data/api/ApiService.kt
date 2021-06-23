package com.example.quotesapp.data.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import com.example.quotesapp.BR
import com.example.quotesapp.data.model.*
import retrofit2.http.*

interface ApiService {
    @POST("session/")
    fun validateWithLogin(
        @Body data: LoginData
    ):Deferred<Response<LoginResponse>>

    @GET("users")
    fun getUserProfile(@Query("login") login: String): Deferred<Response<UserProfile>>

    @GET("typeahead/")
    fun getTagsList(): Deferred<Response<TypeHeadResponse>>

    @GET("quotes/")
    fun getQuotesList(@Query("filter") filter: String, @Query("type") type: String): Deferred<Response<QuoteResponse>>

    @GET("quotes/")
    fun getSearchableQuotesList(@Query("filter") filter: String): Deferred<Response<QuoteResponse>>

    @GET("quotes/")
    fun getMyquotes(@Query("filter") filter: String, @Query("type") type: String): Deferred<Response<QuoteResponse>>

    @POST("quotes/")
    fun postUserQuote(@Body quote: Quote): Deferred<Response<Quote>>

    @GET("quotes/{quote_id}")
    fun GetQuote(@Path("quote_id") quote_id: Int): Deferred<Response<Item>>

    @PUT("quotes/{quote_id}/fav")
    fun favQuote(@Path("quote_id") quote_id: Int): Deferred<Response<Item>>

    @PUT("quotes/{quote_id}/unfav")
    fun unfavQuote(@Path("quote_id") quote_id: Int): Deferred<Response<Item>>

}