package com.example.nitaioanmadalintwittertest.ui.twitteruserdata

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nitaioanmadalintwittertest.data.api.ApiHelper
import com.example.nitaioanmadalintwittertest.data.repository.TwitterRepository

class TwitterUserDataFragmentViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TwitterUserDataFragmentViewModel::class.java)) {
            return TwitterUserDataFragmentViewModel(TwitterRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}