package com.wampinfotech.wampinfotech.modals;

public class TeamModal {
    private String mTitle;
    private String mImageUrl;
    private String mDesc;

    public TeamModal(String title, String imageUrl, String desc) {
        this.mTitle = title;
        this.mImageUrl = imageUrl;
        this.mDesc = desc;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public String getDesc() {
        return mDesc;
    }
}
