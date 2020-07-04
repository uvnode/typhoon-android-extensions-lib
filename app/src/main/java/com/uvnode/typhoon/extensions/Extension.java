package com.uvnode.typhoon.extensions;

import android.os.Parcel;
import android.os.Parcelable;

import com.uvnode.typhoon.extensions.source.MetaSource;

import java.util.ArrayList;

public class Extension implements Parcelable {

    private String name, version, author, packageName;
    private int versionCode;
    private ArrayList<MetaSource> sources;

    public Extension() {
    }

    protected Extension(Parcel in) {
        name = in.readString();
        version = in.readString();
        author = in.readString();
        packageName = in.readString();
        versionCode = in.readInt();
    }

    public static final Creator<Extension> CREATOR = new Creator<Extension>() {
        @Override
        public Extension createFromParcel(Parcel in) {
            return new Extension(in);
        }

        @Override
        public Extension[] newArray(int size) {
            return new Extension[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public void setSources(ArrayList<MetaSource> sources) {
        this.sources = sources;
    }

    public ArrayList<MetaSource> getSources() {
        return sources;
    }

    public final String getApiVersion() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(version);
        parcel.writeString(author);
        parcel.writeString(packageName);
        parcel.writeInt(versionCode);
    }
}
