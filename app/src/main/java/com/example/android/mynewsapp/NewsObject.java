package com.example.android.mynewsapp;

/**
 * Created by Zane on 09/12/2017.
 */

public class NewsObject {
    String mNewsTitle;
    String mNewsContent;

    public NewsObject(String newsTitle, String newsContent) {
        mNewsTitle = newsTitle;
        mNewsContent = newsContent;
    }

    public String getNewsTitle() {
        return mNewsTitle;
    }

    public String getNewsContent() {
        return mNewsContent;
    }

}

