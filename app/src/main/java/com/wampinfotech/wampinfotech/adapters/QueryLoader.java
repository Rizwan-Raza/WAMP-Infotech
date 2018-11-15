package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.wampinfotech.wampinfotech.modals.Query;
import com.wampinfotech.wampinfotech.utils.QueryFetcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class QueryLoader extends AsyncTaskLoader <List <Query>> {
    /**
     * Query URL
     */
    private URL _Url;
    private Context _Context;

    /**
     * Constructs a new {@link QueryLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public QueryLoader(Context context, String url) {
        super(context);
        _Context = context;
//        Toast.makeText(context, "URL: " + url, Toast.LENGTH_SHORT).show();
        try {
            _Url = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStartLoading() {
        // Log.e(LOG_TAG, "Loader Started - onStartLoading()");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List <Query> loadInBackground() {
        // Log.e(LOG_TAG, "Loader Running - loadInBackground()");

        if (_Url == null) {
            return null;
        }
        return QueryFetcher.extractQueries(_Context, _Url);
    }
}
