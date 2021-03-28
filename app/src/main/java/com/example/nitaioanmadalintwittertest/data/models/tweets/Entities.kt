package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Entities (
	@SerializedName("url") val url : Url,
	@SerializedName("description") val description : Description
): Serializable