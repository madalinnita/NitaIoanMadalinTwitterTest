package com.example.nitaioanmadalintwittertest.data.api

import com.example.nitaioanmadalintwittertest.data.models.tweets.TweetsResponse
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject

class ApiHelper(private val apiService: ApiService) {
    suspend fun getUserData(screen_name: String): TwitterUserObject = apiService.getUserData(screen_name)
    suspend fun getLastTweet(screen_name: String): List<TweetsResponse> = apiService.getLastTweet(screen_name)
}