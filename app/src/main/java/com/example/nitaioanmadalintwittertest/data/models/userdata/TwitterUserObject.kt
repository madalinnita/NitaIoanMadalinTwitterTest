package com.example.nitaioanmadalintwittertest.data.models.userdata

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class TwitterUserObject(
    @SerializedName("id") val id: Double,
    @SerializedName("id_str") val id_str: String,
    @SerializedName("name") val name: String,
    @SerializedName("screen_name") val screen_name: String,
    @SerializedName("location") val location: String,
    @SerializedName("url") val url: String,
    @SerializedName("description") val description: String,
    @SerializedName("protected") val protected: Boolean,
    @SerializedName("verified") val verified: Boolean,
    @SerializedName("followers_count") val followers_count: Int,
    @SerializedName("friends_count") val friends_count: Int,
    @SerializedName("listed_count") val listed_count: Int,
    @SerializedName("favourites_count") val favourites_count: Int,
    @SerializedName("statuses_count") val statuses_count: Int,
    @SerializedName("created_at") val created_at: String,
    @SerializedName("profile_banner_url") val profile_banner_url: String,
    @SerializedName("profile_image_url_https") val profile_image_url_https: String,
    @SerializedName("default_profile") val default_profile: Boolean,
    @SerializedName("default_profile_image") val default_profile_image: Boolean
) : Serializable