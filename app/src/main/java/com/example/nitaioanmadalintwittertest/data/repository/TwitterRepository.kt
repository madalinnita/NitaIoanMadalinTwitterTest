package com.example.nitaioanmadalintwittertest.data.repository

import com.example.nitaioanmadalintwittertest.data.api.ApiHelper

class TwitterRepository(private val apiHelper: ApiHelper) {
    suspend fun getUserData(screen_name: String) = apiHelper.getUserData(screen_name)
    suspend fun getLastTweet(screen_name: String) = apiHelper.getLastTweet(screen_name)
}