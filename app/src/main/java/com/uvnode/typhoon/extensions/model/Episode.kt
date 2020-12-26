package com.uvnode.typhoon.extensions.model

import android.os.Parcel
import android.os.Parcelable

class Episode : Parcelable {
    var id: String? = null
    var num: String? = null
    var title: String? = null
    var uri: String? = null
    var image: String? = null

    constructor() {}
    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        num = `in`.readString()
        title = `in`.readString()
        uri = `in`.readString()
        image = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(id)
        parcel.writeString(num)
        parcel.writeString(title)
        parcel.writeString(uri)
        parcel.writeString(image)
    }

    companion object CREATOR : Parcelable.Creator<Episode> {
        override fun createFromParcel(parcel: Parcel): Episode {
            return Episode(parcel)
        }

        override fun newArray(size: Int): Array<Episode?> {
            return arrayOfNulls(size)
        }
    }
}