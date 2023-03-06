package com.bangkit.androidproject.artist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    var name: String = "",
    var listener: String = "",
    var photo: String = "",
    var overview: String = "",
    var detail: String = ""
): Parcelable
