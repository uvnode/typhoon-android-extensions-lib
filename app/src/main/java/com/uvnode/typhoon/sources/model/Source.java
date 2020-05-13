package com.uvnode.typhoon.sources.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Riyadh on 10/29/2016.
 */

public class Source implements Parcelable {
    private String id, name, url, image, description;
    private boolean ready;

    public Source() {
    }

    protected Source(Parcel in) {
        id = in.readString();
        name = in.readString();
        url = in.readString();
        image = in.readString();
        description = in.readString();
        ready = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeString(image);
        dest.writeString(description);
        dest.writeByte((byte) (ready ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Source> CREATOR = new Creator<Source>() {
        @Override
        public Source createFromParcel(Parcel in) {
            return new Source(in);
        }

        @Override
        public Source[] newArray(int size) {
            return new Source[size];
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

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    @Override
    public String toString() {
        return getName();
    }
}
