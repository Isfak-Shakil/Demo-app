package com.example.materialdesign.HelperClass;

public class MostViewedHelperClass {
    int imageMv;
    String titleMv,descriptionMv;

    public MostViewedHelperClass(int imageMv, String titleMv, String descriptionMv) {
        this.imageMv = imageMv;
        this.titleMv = titleMv;
        this.descriptionMv = descriptionMv;
    }

    public int getImageMv() {
        return imageMv;
    }

    public void setImageMv(int imageMv) {
        this.imageMv = imageMv;
    }

    public String getTitleMv() {
        return titleMv;
    }

    public void setTitleMv(String titleMv) {
        this.titleMv = titleMv;
    }

    public String getDescriptionMv() {
        return descriptionMv;
    }

    public void setDescriptionMv(String descriptionMv) {
        this.descriptionMv = descriptionMv;
    }
}
