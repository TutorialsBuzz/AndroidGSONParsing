package com.tutorialsbuzz.androifromgson

import com.google.gson.annotations.SerializedName

data class Model(
    @SerializedName("name") val name: String,
    @SerializedName("age") val age: Int
) {}