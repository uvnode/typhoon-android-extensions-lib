package com.uvnode.typhoon.extensions.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Series implements Parcelable {

    private String source, id, url, title, image, summary;
    private String alternateTitles[], genres[];
    private boolean completed;

    public Series() {
    }

    protected Series(Parcel in) {
        source = in.readString();
        id = in.readString();
        url = in.readString();
        title = in.readString();
        image = in.readString();
        summary = in.readString();
        //alternateTitles = in.createStringArray();
        //genres = in.createStringArray();
        completed = in.readByte() != 0;
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

    public String getSource()   {
        return source;
    }

    public void setSource(String source)    {
        this.source = source;
    }

    public String getId()   {
        return id;
    }

    public void setId(String id)    {
        this.id = id;
    }

    public String getUrl()  {
        return url;
    }

    public void setUrl(String url)    {
        this.url = url;
    }

    public String getTitle()    {
        return title;
    }

    public void setTitle(String title)    {
        this.title = title;
    }

    public String getImage()    {
        return image;
    }

    public void setImage(String image)    {
        this.image = image.replace(" ", "%20");
    }

    public String getSummary()  {
        return summary;
    }

    public void setSummary(String summary)    {
        this.summary = summary;
    }

    public String[] getAlternateTitles()  {
        return alternateTitles;
    }

    public void setAlternateTitles(String alternateTitles[])  {
        this.alternateTitles = alternateTitles;
    }

    public String[] getGenres()  {
        return genres;
    }

    public void getGenres(String genres[])  {
        this.genres = genres;
    }

    public boolean isCompleted()   {
        return completed;
    }

    public void setCompleted(boolean completed)  {
        this.completed = completed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(source);
        dest.writeString(id);
        dest.writeString(url);
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(summary);
        dest.writeByte((byte) (completed ? 1 : 0));
    }


}
