package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class RetweetedStatus (
	@SerializedName("created_at") val created_at : String,
	@SerializedName("id") val id : Int,
	@SerializedName("id_str") val id_str : Int,
	@SerializedName("text") val text : String,
	@SerializedName("truncated") val truncated : Boolean,
	@SerializedName("entities") val entities : Entities,
	@SerializedName("source") val source : String,
	@SerializedName("in_reply_to_status_id") val in_reply_to_status_id : String,
	@SerializedName("in_reply_to_status_id_str") val in_reply_to_status_id_str : String,
	@SerializedName("in_reply_to_user_id") val in_reply_to_user_id : String,
	@SerializedName("in_reply_to_user_id_str") val in_reply_to_user_id_str : String,
	@SerializedName("in_reply_to_screen_name") val in_reply_to_screen_name : String,
	@SerializedName("user") val user : User,
	@SerializedName("geo") val geo : String,
	@SerializedName("coordinates") val coordinates : String,
	@SerializedName("place") val place : String,
	@SerializedName("contributors") val contributors : String,
	@SerializedName("is_quote_status") val is_quote_status : Boolean,
	@SerializedName("retweet_count") val retweet_count : Int,
	@SerializedName("favorite_count") val favorite_count : Int,
	@SerializedName("favorited") val favorited : Boolean,
	@SerializedName("retweeted") val retweeted : Boolean,
	@SerializedName("possibly_sensitive") val possibly_sensitive : Boolean,
	@SerializedName("lang") val lang : String
): Serializable