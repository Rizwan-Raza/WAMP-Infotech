package com.wampinfotech.wampinfotech.modals;

public class TechModal {
    private String mTitle;
    private String mImageUrl;

    public TechModal(String title, String imageUrl) {
        this.mTitle = title;
        this.mImageUrl = imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }
}