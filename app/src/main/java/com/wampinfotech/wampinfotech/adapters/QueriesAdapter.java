package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.Query;
import com.wampinfotech.wampinfotech.utils.Utility;

import java.util.List;

public class QueriesAdapter extends ArrayAdapter <Query> {

    private Context mContext;

    public QueriesAdapter(Context context, List <Query> queries) {
        super(context, 0, queries);
        mContext = context;
    }

    @android.support.annotation.NonNull
    @Override
    public View getView(int position, @android.support.annotation.Nullable View convertView, @android.support.annotation.NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(R.layout.query_item, parent, false);
        }
        Query currentQuery = getItem(position);
        if (currentQuery == null) {
            return listItemView;
        }
        final TextView nameView = listItemView.findViewById(R.id.qi_name);
        nameView.setText(currentQuery.getName());

        final TextView emailView = listItemView.findViewById(R.id.qi_email);
        emailView.setText(currentQuery.getEmail());

        final TextView timeView = listItemView.findViewById(R.id.qi_time);
        timeView.setText(Utility.daysUntilToday(currentQuery.getTime()));

        return listItemView;
    }
}
