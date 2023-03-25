package com.example.submissionapp

import android.os.Parcel
import android.os.Parcelable


data class Foods(
    val name : String,
    val desc : String,
    val photo : Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(desc)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Foods> {
        override fun createFromParcel(parcel: Parcel): Foods {
            return Foods(parcel)
        }

        override fun newArray(size: Int): Array<Foods?> {
            return arrayOfNulls(size)
        }
    }
}