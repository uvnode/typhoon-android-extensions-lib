package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {

    private String id, name, url;

    public Genre() {
    }

    protected Genre(Parcel in) {
        id = in.readString();
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    public String getId()   {
        return id;
    }

    public void setId(String id)    {
        this.id = id;
    }

    public String getName()   {
        return name;
    }

    public void setName(String name)    {
        this.name = name;
    }

    public String getUrl()  {
        return url;
    }

    public void setUrl(String url)    {
        this.url = url;
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
