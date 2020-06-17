package com.uvnode.typhoon.extensions;

public class ExtensionHolder {

    private Extension extension;
    private String repo;
    private boolean isInstalled;

    public ExtensionHolder() {
    }

    public String getRepo() {
        return repo;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }
}
