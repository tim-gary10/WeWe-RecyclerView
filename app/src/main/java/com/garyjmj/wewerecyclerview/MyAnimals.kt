package com.garyjmj.wewerecyclerview

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class MyAnimals (var name: String?, var eat: String?, var photo: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(eat)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyAnimals> {
        override fun createFromParcel(parcel: Parcel): MyAnimals {
            return MyAnimals(parcel)
        }

        override fun newArray(size: Int): Array<MyAnimals?> {
            return arrayOfNulls(size)
        }
    }

}