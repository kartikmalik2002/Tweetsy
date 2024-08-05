package com.example.tweetsy.api

import com.example.tweetsy.models.TweetListItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface TweetsyApi {
    @GET("/v3/b/669fcc9aacd3cb34a86a39b7?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") Category : String) : Response<List<TweetListItem>>

    @GET("/v3/b/669fcc9aacd3cb34a86a39b7?meta=false")
    @Headers("X-JSON-Path: tweets..category")
    suspend fun getCategories() : Response<List<String>>

}