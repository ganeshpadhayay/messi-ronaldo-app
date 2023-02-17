package com.example.ganesh.messi_ronaldo.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    @field:SerializedName("id")
    val id: Int? = null,
    @field:SerializedName("released")
    val released: String? = null,
    @field:SerializedName("background_image")
    val backgroundImage: String? = null,
    @field:SerializedName("background_image_additional")
    val backgroundImageAdditional: String? = null,
    @field:SerializedName("name")
    val name: String? = null,
    @field:SerializedName("description")
    val description: String? = null,
) : Parcelable
