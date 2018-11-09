package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.dashboard.QueriesFragment;
import com.wampinfotech.wampinfotech.dashboard.VisitorsFragment;

public class DashboardAdapter extends FragmentPagerAdapter {

    /**
     * Context of the app
     */
    private Context _Context;

    /**
     * Create a new {@link DashboardAdapter} object.
     *
     * @param context is the context of the app
     * @param fm      is the fragment manager that will keep each fragment's state in the adapter
     *                across swipes.
     */
    public DashboardAdapter(Context context, FragmentManager fm) {
        super(fm);
        _Context = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new VisitorsFragment();
        } else if (position == 1) {
            return new QueriesFragment();
//        } else if (position == 2) {
//            return new ColorsFragment();
//        } else {
//            return new PhrasesFragment();
        }
        return null;
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