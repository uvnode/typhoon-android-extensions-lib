package com.uvnode.typhoon.extensions.model

import android.os.Parcel
import android.os.Parcelable

class Ranking : Parcelable {
    var id: String? = null
    var name: String? = null
    var uri: String? = null

    constructor() {}
    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        name = `in`.readString()
        uri = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeString(uri)
    }

    companion object CREATOR : Parcelable.Creator<Ranking> {
        override fun createFromParcel(parcel: Parcel): Ranking {
            return Ranking(parcel)
        }

        override fun newArray(size: Int): Array<Ranking?> {
            return arrayOfNulls(size)
        }
    }

}