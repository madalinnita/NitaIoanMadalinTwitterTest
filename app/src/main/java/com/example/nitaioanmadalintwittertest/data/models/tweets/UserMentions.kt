package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class UserMentions (
	@SerializedName("screen_name") val screen_name : String,
	@SerializedName("name") val name : String,
	@SerializedName("id") val id : Int,
	@SerializedName("id_str") val id_str : Int,
	@SerializedName("indices") val indices : List<Int>
): Serializable