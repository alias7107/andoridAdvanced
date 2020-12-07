package com.example.quotesapp.data.api

import kotlinx.coroutines.Deferred
import retrofit2.Response
import com.example.quotesapp.BR
import com.example.quotesapp.data.model.*
import retrofit2.http.*

interface ApiService {
//    @Headers(
//        "Content-Type: application/json",
//        "Authorization: Token token=3076049eda9ba452981badda30fe2d47")
    @GET("quotes/")
    fun getQuotesList(@Query("filter") filter: String, @Query("type") type: String): Deferred<Response<QuoteResponse>>

    @GET("quotes/")
    fun getSearchableQuotesList(@Query("filter") filter: String): Deferred<Response<QuoteResponse>>
    @GET("quotes/")
    fun getMyquotes(@Query("filter") filter: String, @Query("type") type: String): Deferred<Response<QuoteResponse>>

    @POST("quotes/")
    fun postUserQuote(@Body quote: Quote): Deferred<Response<Quote>>


    @GET("typeahead/")
    fun getTagsList(): Deferred<Response<TypeHeadResponse>>

    @POST("session/")
    fun validateWithLogin(
        @Body data: LoginData
    ):Deferred<Response<LoginResponse>>

    @GET("users")
    fun getUserProfile(@Query("login") login: String): Deferred<Response<UserProfile>>

    @PUT("quotes/{quote_id}/fav")
    fun favQuote(@Path("quote_id") quote_id: Int): Deferred<Response<QuoteResponse>>

}