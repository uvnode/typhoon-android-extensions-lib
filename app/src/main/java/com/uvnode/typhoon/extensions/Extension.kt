package com.uvnode.typhoon.extensions

import android.os.Parcel
import android.os.Parcelable
import com.uvnode.typhoon.extensions.source.MetaSource

class Extension : Parcelable {
    var name: String? = null
    var version: String? = null
    var author: String? = null
    var packageName: String? = null
    var versionCode = 0
    var sources: List<MetaSource>? = null

    constructor() {}
    protected constructor(`in`: Parcel) {
        name = `in`.readString()
        version = `in`.readString()
        author = `in`.readString()
        packageName = `in`.readString()
        versionCode = `in`.readInt()
    }

    val apiVersion: String
        get() = BuildConfig.VERSION_NAME

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(name)
        parcel.writeString(version)
        parcel.writeString(author)
        parcel.writeString(packageName)
        parcel.writeInt(versionCode)
    }

    companion object CREATOR : Parcelable.Creator<Extension> {
        override fun createFromParcel(parcel: Parcel): Extension {
            return Extension(parcel)
        }

        override fun newArray(size: Int): Array<Extension?> {
            return arrayOfNulls(size)
        }
    }
}