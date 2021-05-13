package com.drunken.dicoding.gamedex.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Game(
    val name : String,
    val description : String,
    val publisher : String,
    val rating : Float,
    val image : Int
) : Parcelable
