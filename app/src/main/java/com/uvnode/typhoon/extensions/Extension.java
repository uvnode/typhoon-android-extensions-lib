package com.uvnode.typhoon.extensions;

import android.content.Context;

import java.util.ArrayList;

public class Extension {

    private String name, icon, version, author, packageName;
    private int versionCode;
    private ArrayList<MetaSource> sources;

    public Extension() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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
}
