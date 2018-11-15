package com.wampinfotech.wampinfotech.dashboard;

import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.adapters.VisitorLoader;
import com.wampinfotech.wampinfotech.adapters.VisitorsAdapter;
import com.wampinfotech.wampinfotech.modals.Client;
import com.wampinfotech.wampinfotech.modals.Visitor;
import com.wampinfotech.wampinfotech.utils.Utility;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class VisitorsFragment extends Fragment implements LoaderManager.LoaderCallbacks <List <Visitor>> {

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int VISITORS_LOADER_ID = 1;
    TextView mEmptyStateTextView;
    /**
     * URL for earthquake data from the USGS dataset
     */
    private String REQUEST_URL;
    /**
     * Adapter for the list of earthquakes
     */
    private VisitorsAdapter mAdapter;
    private View mView;

    public VisitorsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Client client = (Client) getArguments().getSerializable("client");
        REQUEST_URL = client.getVisitorsApiUrl();

        mView = inflater.inflate(R.layout.fragment_visitors, container, false);

//        TextView tvCount = view.findViewById(R.id.visitors_count);
//        tvCount.setText("Total number of visitors: " + visitors.size());

        ListView visitorsList = mView.findViewById(R.id.visitors_list);
        visitorsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <?> parent, View view, int position, long id) {
                // Creating alert Dialog with one Button
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext(), R.style.Theme_AppCompat_Light_Dialog_Alert);

                //AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                // Setting Dialog Title
                alertDialog.setTitle("Visitor's Details");
                Visitor visitor = mAdapter.getItem(position);

                View alertView = LayoutInflater.from(getContext()).inflate(R.layout.visitor_alert, parent, false);
                if (visitor != null) {
                    TextView ipAddr = alertView.findViewById(R.id.visitor_a_ip);
                    ipAddr.setText(visitor.getIpAddr());
                    TextView vTime = alertView.findViewById(R.id.visitor_a_time);
                    SimpleDateFormat df = new SimpleDateFormat("EEE, MMM dd, yyyy 'at' hh:mm aaa", Locale.ENGLISH);
                    String time = df.format(visitor.getTime());
                    vTime.setText(time);
                }
                alertDialog.setView(alertView);

                final int vId = visitor != null ? visitor.getVid() : 0;

                alertDialog.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteVisitor(vId);
                    }
                });
                alertDialog.setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                alertDialog.show();

            }
        });
        mEmptyStateTextView = mView.findViewById(R.id.empty_view);
        visitorsList.setEmptyView(mEmptyStateTextView);

        // Create a new {@link ArrayAdapter} of earthquakes
        mAdapter = new VisitorsAdapter(mView.getContext(), new ArrayList <Visitor>());

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        visitorsList.setAdapter(mAdapter);

        // Get a reference to the LoaderManager, in order to interact with loaders.
        LoaderManager loaderManager = getActivity().getSupportLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(VISITORS_LOADER_ID, null, this);

        return mView;
    }

    @NonNull
    @Override
    public Loader <List <Visitor>> onCreateLoader(int i, @Nullable Bundle bundle) {

        Uri baseUri = Uri.parse(REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        String salt = "*WAMP*";
        String anotherOne = (new SimpleDateFormat("yy", Locale.ENGLISH)).format(Calendar.getInstance().getTime());
        uriBuilder.appendQueryParameter("token", Utility.md5(salt + anotherOne + salt));
        uriBuilder.appendQueryParameter("order", "time");
        uriBuilder.appendQueryParameter("sort", "DESC");

        // Create a new loader for the given URL
        // Log.e(LOG_TAG, "Loader Created - onCreateLoader()");
        return new VisitorLoader(getContext(), uriBuilder.toString());
    }

    @Override
    public void onLoadFinished(@NonNull Loader <List <Visitor>> loader, List <Visitor> visitors) {
        // Hide loading indicator because the data has been loaded
        View loadingIndicator = mView.findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        // Set empty state text to display "No earthquakes found."
        mEmptyStateTextView.setText(getString(R.string.no_visitors));

        // Log.e(LOG_TAG, "Loader Finished - onLoadFinished()");
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (visitors != null && !visitors.isEmpty()) {
            mAdapter.addAll(visitors);
        }
    }

    @Override
    public void onLoaderReset(@NonNull Loader <List <Visitor>> loader) {
        // Log.e(LOG_TAG, "Loader Reset - onLoadReset()");
        // Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }

    boolean deleteVisitor(int vId) {
        // TODO Remove visitor from DB with vId:ID
        return false;
    }
}
