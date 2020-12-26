package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ranking implements Parcelable {

    private String id, name, uri;

    public Ranking() {
    }

    protected Ranking(Parcel in) {
        id = in.readString();
        name = in.readString();
        uri = in.readString();
    }

    public static final Creator<Series> CREATOR = new Creator<Series>() {
        @Override
        public Series createFromParcel(Parcel in) {
            return new Series(in);
        }

        @Override
        public Series[] newArray(int size) {
            return new Series[size];
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

    public String getUri()  {
        return uri;
    }

    public void setUri(String uri)    {
        this.uri = uri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(uri);
    }


}
