package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Urls (
	@SerializedName("url") val url : String,
	@SerializedName("expanded_url") val expanded_url : String,
	@SerializedName("display_url") val display_url : String,
	@SerializedName("indices") val indices : List<Int>
): Serializable