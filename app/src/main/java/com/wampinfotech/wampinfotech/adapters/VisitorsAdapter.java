package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.Visitor;

import java.util.List;

public class VisitorsAdapter extends ArrayAdapter <Visitor> {

    private Context mContext;

    public VisitorsAdapter(Context context, List <Visitor> visitors) {
        super(context, 0, visitors);
        mContext = context;
    }

    @android.support.annotation.NonNull
    @Override
    public View getView(int position, @android.support.annotation.Nullable View convertView, @android.support.annotation.NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(mContext).inflate(R.layout.visitor_item, parent, false);
        }
        Visitor currentVisitor = getItem(position);
        if (currentVisitor == null) {
            return listItemView;
        }
        final TextView ipView = listItemView.findViewById(R.id.visitor_ip);
        ipView.setText(currentVisitor.getIpAddr());

        final TextView timeView = listItemView.findViewById(R.id.visitor_time);
        timeView.setText(currentVisitor.getTime());

        return listItemView;
    }
}
