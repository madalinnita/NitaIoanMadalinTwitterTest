package com.example.nitaioanmadalintwittertest.ui.twitteruserdata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitaioanmadalintwittertest.data.models.tweets.TweetsResponse
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject
import com.example.nitaioanmadalintwittertest.data.repository.TwitterRepository
import com.example.nitaioanmadalintwittertest.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class TwitterUserDataFragmentViewModel(private val twitterRepository: TwitterRepository): ViewModel() {

    private val lastTweetResponse = MutableLiveData<Resource<List<TweetsResponse>>>()

    fun getLastTweet(screen_name: String?) {
        if(!screen_name.isNullOrEmpty()) {
            viewModelScope.launch {
                lastTweetResponse.postValue(Resource.loading(data = null))
                withContext(Dispatchers.IO) {
                    try {
                        lastTweetResponse.postValue(
                            Resource.success(
                                data = twitterRepository.getLastTweet(
                                    screen_name
                                )
                            )
                        )
                    } catch (exception: Exception) {
                        lastTweetResponse.postValue(
                            Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!"
                            )
                        )
                    }
                }
            }
        } else {
            lastTweetResponse.postValue(
                Resource.error(
                    data = null,
                    message = "Please enter a valid user"
                )
            )
        }
    }

    fun getLastTweetResponse(): LiveData<Resource<List<TweetsResponse>>> = lastTweetResponse
}