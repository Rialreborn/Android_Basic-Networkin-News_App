package com.example.android.mynewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zane on 09/12/2017.
 */

public class NewsAdapter extends ArrayAdapter<NewsObject> {

    private List<NewsObject> news = new ArrayList<>();

    public NewsAdapter(Context context, List<NewsObject> news) {
        super(context, 0, news);
    }





    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_item, parent, false);
        }

        NewsObject newsObject = getItem(position);

        TextView titleTextView = listItemView.findViewById(R.id.title_news_item);
        titleTextView.setText(newsObject.getNewsTitle());

        TextView contentTextView = listItemView.findViewById(R.id.content_news_item);
        contentTextView.setText(newsObject.getNewsContent());

        return listItemView;
    }
}
