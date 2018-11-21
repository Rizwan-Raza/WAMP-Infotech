package com.wampinfotech.wampinfotech.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.adapters.QueriesAdapter;
import com.wampinfotech.wampinfotech.adapters.QueryLoader;
import com.wampinfotech.wampinfotech.modals.Client;
import com.wampinfotech.wampinfotech.modals.Query;
import com.wampinfotech.wampinfotech.utils.Utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class QueriesFragment extends Fragment implements LoaderManager.LoaderCallbacks <List <Query>> {

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int QUERIES_LOADER_ID = 2;
    TextView mEmptyStateTextView;
    /**
     * URL for earthquake data from the USGS dataset
     */
    private String REQUEST_URL;
    /**
     * Adapter for the list of earthquakes
     */
    private QueriesAdapter mAdapter;
    private View mView;

    public QueriesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final Client client = (Client) getArguments().getSerializable("client");
        REQUEST_URL = client.getQueriesApiUrl();

        mView = inflater.inflate(R.layout.fragment_queries, container, false);

        ListView queriesList = mView.findViewById(R.id.queries_list);

        queriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> adapterView, View view, int position, long l) {
                Query query = mAdapter.getItem(position);
                Intent myIntent = new Intent(getContext(), QueryDetails.class);
                myIntent.putExtra("query", query);
                myIntent.putExtra("queryURL", client.getQueriesApiUrl());
                startActivity(myIntent);
            }
        });

        mEmptyStateTextView = mView.findViewById(R.id.empty_view);
        queriesList.setEmptyView(mEmptyStateTextView);

        // Create a new {@link ArrayAdapter} of earthquakes
        mAdapter = new QueriesAdapter(mView.getContext(), new ArrayList <Query>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        queriesList.setAdapter(mAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getActivity().getSupportLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(QUERIES_LOADER_ID, null, this);

        return mView;
    }

    @NonNull
    @Override
    public Loader <List <Query>> onCreateLoader(int i, @Nullable Bundle bundle) {

        Uri baseUri = Uri.parse(REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        String salt = "*WAMP*";
        String anotherOne = (new SimpleDateFormat("yy", Locale.ENGLISH)).format(Calendar.getInstance().getTime());
        uriBuilder.appendQueryParameter("token", Utility.md5(salt + anotherOne + salt));
        uriBuilder.appendQueryParameter("order", "time");
        uriBuilder.appendQueryParameter("sort", "DESC");

        // Create a new loader for the given URL
        // Log.e(LOG_TAG, "Loader Created - onCreateLoader()");
        return new QueryLoader(getContext(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader <List <Query>> loader, List <Query> queries) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = mView.findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(R.string.no_queries);

        // Log.e(LOG_TAG, "Loader Finished - onLoadFinished()");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (queries != null && !queries.isEmpty()) {
            mAdapter.addAll(queries);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader <List <Query>> loader) {
        // Log.e(LOG_TAG, "Loader Reset - onLoadReset()");
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
