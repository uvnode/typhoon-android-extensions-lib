package com.uvnode.typhoon.sources.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Riyadh on 7/23/2017.
 */

public class Mirror implements Parcelable{

    private int id;
    private String name, link;

    public Mirror() {
    }

    protected Mirror(Parcel in) {
        id = in.readInt();
        name = in.readString();
        link = in.readString();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "{name: " + name + ", link: " + link + "}";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(link);
    }
}
