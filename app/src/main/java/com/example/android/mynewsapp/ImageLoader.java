package com.example.android.mynewsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by Zane on 10/12/2017.
 */

public class ImageLoader extends AsyncTaskLoader {

    private String mUrl;

    public ImageLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public Bitmap loadInBackground() {
        if (mUrl == null) {
            return null;
        }
        try {
            byte [] encodeByte= Base64.decode(mUrl,Base64.DEFAULT);

            InputStream inputStream  = new ByteArrayInputStream(encodeByte);
            Bitmap bitmap  = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
}
