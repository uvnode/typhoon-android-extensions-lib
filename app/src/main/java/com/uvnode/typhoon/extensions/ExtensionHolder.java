package com.uvnode.typhoon.extensions;

public class ExtensionHolder {

    private Extension extension;
    private String repoId;
    private boolean isInstalled;

    public ExtensionHolder() {
    }

    public String getRepo() {
        return repoId;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    public void setRepo(String repoId) {
        this.repoId = repoId;
    }

    public boolean isInstalled() {
        return isInstalled;
    }

    public void setInstalled(boolean installed) {
        isInstalled = installed;
    }
}
