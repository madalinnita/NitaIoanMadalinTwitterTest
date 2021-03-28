package com.example.nitaioanmadalintwittertest.ui.chooseuser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nitaioanmadalintwittertest.data.api.ApiHelper
import com.example.nitaioanmadalintwittertest.data.repository.TwitterRepository

class ChooseUserFragmentViewModelFactory(private val apiHelper: ApiHelper) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ChooseUserFragmentViewModel::class.java)) {
            return ChooseUserFragmentViewModel(TwitterRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}