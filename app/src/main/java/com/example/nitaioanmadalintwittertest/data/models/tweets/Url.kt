package com.example.nitaioanmadalintwittertest.data.models.tweets

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Url (
	@SerializedName("urls") val urls : List<Urls>
): Serializable