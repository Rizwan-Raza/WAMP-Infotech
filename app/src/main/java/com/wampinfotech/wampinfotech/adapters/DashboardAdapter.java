package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.dashboard.VisitorsFragment;
import com.wampinfotech.wampinfotech.modals.Client;

public class DashboardAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context _Context;
    private Client mClient;

    /**
     * Create a new {@link DashboardAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     * @param client  is the client object of representing the current client
     */
    public DashboardAdapter(Context context, FragmentManager fm, Client client) {
        super(fm);
        _Context = context;
        mClient = client;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        if (position == 0) {
            frag = new VisitorsFragment();
        } else if (position == 1) {
            frag = new VisitorsFragment();
//        } else if (position == 2) {
//            return new ColorsFragment();
//        } else {
//            return new PhrasesFragment();
        }
        if (frag != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("client", mClient);
            frag.setArguments(bundle);
        }
        return frag;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return _Context.getString(R.string.visitors);
        } else if (position == 1) {
            return _Context.getString(R.string.queries);
//        } else if (position == 2) {
//            return _Context.getString(R.string.category_colors);
//        } else {
//            return _Context.getString(R.string.category_phrases);
        }
        return null;
    }
}