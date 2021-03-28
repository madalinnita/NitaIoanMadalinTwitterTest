package com.example.nitaioanmadalintwittertest.ui.chooseuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject
import com.example.nitaioanmadalintwittertest.data.repository.TwitterRepository
import com.example.nitaioanmadalintwittertest.data.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class ChooseUserFragmentViewModel(private val twitterRepository: TwitterRepository): ViewModel() {

    private val twitterResponse = MutableLiveData<Resource<TwitterUserObject>>()

    fun getUserData(screen_name: String?) {
        if(!screen_name.isNullOrEmpty()) {
            viewModelScope.launch {
                twitterResponse.postValue(Resource.loading(data = null))
                withContext(Dispatchers.IO) {
                    try {
                        twitterResponse.postValue(
                            Resource.success(
                                data = twitterRepository.getUserData(
                                    screen_name
                                )
                            )
                        )
                    } catch (exception: Exception) {
                        twitterResponse.postValue(
                            Resource.error(
                                data = null,
                                message = exception.message ?: "Error Occurred!"
                            )
                        )
                    }
                }
            }
        } else {
            twitterResponse.postValue(
                Resource.error(
                    data = null,
                    message = "Please enter a valid user"
                )
            )
        }
    }

    fun getTwitterResponse(): LiveData<Resource<TwitterUserObject>> = twitterResponse
}