package com.example.android.mynewsapp;

import android.graphics.Bitmap;

/**
 * Created by Zane on 09/12/2017.
 */

public class NewsObject {
    String mNewsTitle;
    String mNewsContent;
    String mNewsUrl;
    Bitmap mNewsImage;

    public NewsObject(String newsTitle, String newsContent, String newsUrl, Bitmap newsImage) {
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

    public Bitmap getNewsImage() {
        return mNewsImage;
    }

}

