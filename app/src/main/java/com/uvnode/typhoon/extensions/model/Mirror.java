package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Mirror implements Parcelable{

    private String id, name, url;

    public Mirror() {}

    protected Mirror(Parcel in) {
        id = in.readString();
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Mirror> CREATOR = new Creator<Mirror>() {
        @Override
        public Mirror createFromParcel(Parcel in) {
            return new Mirror(in);
        }

        @Override
        public Mirror[] newArray(int size) {
            return new Mirror[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String link) {
        this.url = link;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", url: " + url + "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeString(url);
    }
}
