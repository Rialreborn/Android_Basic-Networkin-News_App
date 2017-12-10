package com.example.android.mynewsapp;

/**
 * Created by Zane on 09/12/2017.
 */

public class NewsObject {
    String mNewsTitle;
    String mNewsContent;
    String mNewsUrl;
    String mNewsImage;

    public NewsObject(String newsTitle, String newsContent, String newsUrl, String newsImage) {
        mNewsTitle = newsTitle;
        mNewsContent = newsContent;
        mNewsUrl = newsUrl;
        mNewsImage = newsImage;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getNewsContent() {
        return mNewsContent;
    }

    public String getNewsUrl() {
        return mNewsUrl;
    }

    public String getNewsImage() {
        return mNewsImage;
    }

}

