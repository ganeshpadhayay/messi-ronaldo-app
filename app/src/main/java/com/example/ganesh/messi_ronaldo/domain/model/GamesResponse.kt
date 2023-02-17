package com.example.ganesh.messi_ronaldo.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GamesResponse(
    @field:SerializedName("next")
    val next: String? = null,
    @field:SerializedName("previous")
    val previous: String? = null,
    @field:SerializedName("count")
    val count: Int,
    @field:SerializedName("results")
    val results: List<Games> = listOf(),
) : Parcelable