package com.raywenderlich.tbc_asignment_profile_screen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
class Profile(val name: String, val lastName: String, val email: String, val date: String, val gender:Int):Parcelable {



}