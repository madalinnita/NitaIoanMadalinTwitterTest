package com.example.nitaioanmadalintwittertest.data.api

import com.example.nitaioanmadalintwittertest.data.models.tweets.TweetsResponse
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users/show.json")
    suspend fun getUserData(@Query("screen_name") screen_name: String): TwitterUserObject

    @GET("statuses/user_timeline.json")
    suspend fun getLastTweet(@Query("screen_name") screen_name: String, @Query("count") count: Int = 1): List<TweetsResponse>
}