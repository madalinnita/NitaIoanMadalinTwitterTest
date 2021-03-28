package com.example.nitaioanmadalintwittertest.ui.twitteruserdata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.nitaioanmadalintwittertest.R
import com.example.nitaioanmadalintwittertest.data.api.ApiHelper
import com.example.nitaioanmadalintwittertest.data.api.RetrofitBuilder
import com.example.nitaioanmadalintwittertest.data.models.userdata.TwitterUserObject
import com.example.nitaioanmadalintwittertest.data.utils.CallStatus
import kotlinx.android.synthetic.main.fragment_twitter_user_data.*

class TwitterUserDataFragment : Fragment() {

    private val args: TwitterUserDataFragmentArgs by navArgs()
    private lateinit var userData: TwitterUserObject

    private val viewModel: TwitterUserDataFragmentViewModel by viewModels {
        TwitterUserDataFragmentViewModelFactory(
            ApiHelper(RetrofitBuilder.apiTwitterService)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userData = args.userData
        return inflater.inflate(R.layout.fragment_twitter_user_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUI()
        viewModel.getLastTweet(userData.screen_name)
        observeLastTweet()
    }

    private fun setUI() {
        Glide.with(requireContext())
            .load(userData.profile_image_url_https.replace("_normal", ""))
            .into(profile_imageView)
        name_tv.text = userData.name
    }

    private fun observeLastTweet() {
        viewModel.getLastTweetResponse().observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    CallStatus.SUCCESS -> {
                        progressBar.visibility = View.GONE
                        resource.data?.get(0)?.let { lastTweet ->
                            last_tweet_tv.text = lastTweet.text
                        }
                    }
                    CallStatus.ERROR -> {
                        progressBar.visibility = View.GONE
                        last_tweet_tv.text = resource.message
                    }
                    CallStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                    }
                }
            }
        })
    }
}