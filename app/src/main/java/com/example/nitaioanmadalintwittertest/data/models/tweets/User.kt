package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class User(
	@SerializedName("id") val id: Int,
	@SerializedName("id_str") val id_str: Int,
	@SerializedName("name") val name: String,
	@SerializedName("screen_name") val screen_name: String,
	@SerializedName("location") val location: String,
	@SerializedName("description") val description: String,
	@SerializedName("url") val url: String,
	@SerializedName("entities") val entities: Entities,
	@SerializedName("protected") val protected: Boolean,
	@SerializedName("followers_count") val followers_count: Int,
	@SerializedName("friends_count") val friends_count: Int,
	@SerializedName("listed_count") val listed_count: Int,
	@SerializedName("created_at") val created_at: String,
	@SerializedName("favourites_count") val favourites_count: Int,
	@SerializedName("utc_offset") val utc_offset: Int,
	@SerializedName("time_zone") val time_zone: String,
	@SerializedName("geo_enabled") val geo_enabled: Boolean,
	@SerializedName("verified") val verified: Boolean,
	@SerializedName("statuses_count") val statuses_count: Int,
	@SerializedName("lang") val lang: String,
	@SerializedName("contributors_enabled") val contributors_enabled: Boolean,
	@SerializedName("is_translator") val is_translator: Boolean,
	@SerializedName("is_translation_enabled") val is_translation_enabled: Boolean,
	@SerializedName("profile_background_color") val profile_background_color: String,
	@SerializedName("profile_background_image_url") val profile_background_image_url: String,
	@SerializedName("profile_background_image_url_https") val profile_background_image_url_https: String,
	@SerializedName("profile_background_tile") val profile_background_tile: Boolean,
	@SerializedName("profile_image_url") val profile_image_url: String,
	@SerializedName("profile_image_url_https") val profile_image_url_https: String,
	@SerializedName("profile_banner_url") val profile_banner_url: String,
	@SerializedName("profile_link_color") val profile_link_color: String,
	@SerializedName("profile_sidebar_border_color") val profile_sidebar_border_color: String,
	@SerializedName("profile_sidebar_fill_color") val profile_sidebar_fill_color: String,
	@SerializedName("profile_text_color") val profile_text_color: Int,
	@SerializedName("profile_use_background_image") val profile_use_background_image: Boolean,
	@SerializedName("has_extended_profile") val has_extended_profile: Boolean,
	@SerializedName("default_profile") val default_profile: Boolean,
	@SerializedName("default_profile_image") val default_profile_image: Boolean,
	@SerializedName("following") val following: Boolean,
	@SerializedName("follow_request_sent") val follow_request_sent: Boolean,
	@SerializedName("notifications") val notifications: Boolean,
	@SerializedName("translator_type") val translator_type: String
): Serializable