package com.example.android.mynewsapp;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsObject>>{

    List<NewsObject> newsArray = new ArrayList<>();

    private NewsAdapter adapter;

    private static final int loader_id = 1;

    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView newsListView = findViewById(R.id.list);
        adapter = new NewsAdapter(this, new ArrayList<NewsObject>());

        newsListView.setAdapter(adapter);

        LoaderManager loaderManager = getLoaderManager();

        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();
        if (isConnected){
            loaderManager.initLoader(loader_id, null, this);
        } else {
            mEmptyStateTextView = (TextView) findViewById(R.id.empty_state);
            newsListView.setEmptyView(mEmptyStateTextView);
            View progressBar = (View) findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.GONE);
            mEmptyStateTextView.setText(R.string.network_issues);
            ImageView imageView = (ImageView) findViewById(R.id.empty_state_image);
            imageView.setVisibility(View.VISIBLE);
        }

        newsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                NewsObject currentNewsObject = adapter.getItem(position);

                Uri newsUri = Uri.parse((currentNewsObject.getNewsUrl()));

                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, newsUri);

                startActivity(websiteIntent);
            }
        });

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_state);
        newsListView.setEmptyView(mEmptyStateTextView);

    }

    @Override
    public Loader<List<NewsObject>> onCreateLoader(int id, Bundle args) {
        String url = "https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=e6afa0c9cda5412b9360587963f4ec32";
        return new NewsLoader(this, url);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsObject>> loader, List<NewsObject> data) {
        View progressbar = (View) findViewById(R.id.progress_bar);
        progressbar.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_news_found);
        adapter.clear();

        if (data != null && !data.isEmpty()) {
            adapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsObject>> loader) {
        adapter.clear();
    }
}
