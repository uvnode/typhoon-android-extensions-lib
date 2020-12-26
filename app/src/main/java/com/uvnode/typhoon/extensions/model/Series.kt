package com.uvnode.typhoon.extensions.model

import android.os.Parcel
import android.os.Parcelable

class Series : Parcelable {
    var source: String? = null
    var id: String? = null
    var uri: String? = null
    var title: String? = null
    var image: String? = null
        private set
    var description: String? = null
    var isCompleted = false

    constructor() {}
    constructor(`in`: Parcel) {
        source = `in`.readString()
        id = `in`.readString()
        uri = `in`.readString()
        title = `in`.readString()
        image = `in`.readString()
        description = `in`.readString()
        isCompleted = `in`.readByte().toInt() != 0
    }

    fun setImage(image: String) {
        this.image = image.replace(" ", "%20")
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(source)
        dest.writeString(id)
        dest.writeString(uri)
        dest.writeString(title)
        dest.writeString(image)
        dest.writeString(description)
        dest.writeByte((if (isCompleted) 1 else 0).toByte())
    }

    companion object CREATOR : Parcelable.Creator<Series> {
        override fun createFromParcel(parcel: Parcel): Series {
            return Series(parcel)
        }

        override fun newArray(size: Int): Array<Series?> {
            return arrayOfNulls(size)
        }
    }

}