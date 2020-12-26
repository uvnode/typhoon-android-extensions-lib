package com.uvnode.typhoon.extensions.model

import android.os.Parcel
import android.os.Parcelable

class Mirror : Parcelable {
    var id: String? = null
    var name: String? = null
    var uri: String? = null

    constructor() {}
    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        name = `in`.readString()
        uri = `in`.readString()
    }

    override fun toString(): String {
        return "{name: $name, url: $uri}"
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(id)
        parcel.writeString(name)
        parcel.writeString(uri)
    }

    companion object {
        val CREATOR: Parcelable.Creator<Mirror?> = object : Parcelable.Creator<Mirror?> {
            override fun createFromParcel(`in`: Parcel): Mirror? {
                return Mirror(`in`)
            }

            override fun newArray(size: Int): Array<Mirror?> {
                return arrayOfNulls(size)
            }
        }
    }
}