package com.uvnode.typhoon.extensions.model

import android.os.Parcel
import android.os.Parcelable

class Source : Parcelable {
    var id: String? = null
    var name: String? = null
    var url: String? = null
    var image: String? = null
    var description: String? = null
    var isReady = false

    constructor() {}
    protected constructor(`in`: Parcel) {
        id = `in`.readString()
        name = `in`.readString()
        url = `in`.readString()
        image = `in`.readString()
        description = `in`.readString()
        isReady = `in`.readByte().toInt() != 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(name)
        dest.writeString(url)
        dest.writeString(image)
        dest.writeString(description)
        dest.writeByte((if (isReady) 1 else 0).toByte())
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return name!!
    }

    companion object CREATOR : Parcelable.Creator<Source> {
        override fun createFromParcel(parcel: Parcel): Source {
            return Source(parcel)
        }

        override fun newArray(size: Int): Array<Source?> {
            return arrayOfNulls(size)
        }
    }
}