package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Riyadh on 5/31/2016.
 */
public class Episode implements Parcelable {

    private String id, title, url, image;

    public Episode()    {
    }

    protected Episode(Parcel in) {
        id = in.readString();
        title = in.readString();
        url = in.readString();
        image = in.readString();
    }

    public static final Creator<Episode> CREATOR = new Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel in) {
            return new Episode(in);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id)   {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)   {
        this.title = title;
    }

    public String getUrl()    {
        return url;
    }

    public void setUrl(String url)  {
        this.url = url;
    }

    public String getImage()    {
        return image;
    }

    public void setImage(String image)  {
        this.image = image;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(url);
        dest.writeString(image);
    }
}
