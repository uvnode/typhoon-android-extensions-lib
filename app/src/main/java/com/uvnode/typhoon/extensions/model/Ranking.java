package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Ranking implements Parcelable {

    private String id, name, url;

    public Ranking() {
    }

    protected Ranking(Parcel in) {
        id = in.readString();
        name = in.readString();
        url = in.readString();
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(url);
    }


}
