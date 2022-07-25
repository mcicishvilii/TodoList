package com.example.UsersApp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    var firstName: String,
    var lastName:String,
    var age:Int
):Parcelable

val usersList = mutableListOf<User>(

)