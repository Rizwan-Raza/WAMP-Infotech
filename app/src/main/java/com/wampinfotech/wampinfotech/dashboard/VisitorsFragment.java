package com.wampinfotech.wampinfotech.dashboard;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.wampinfotech.wampinfotech.R;

import java.util.ArrayList;

public class VisitorsFragment extends Fragment {
    public VisitorsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ArrayList <String> visitors = new ArrayList <String>();
        visitors.add("Koi aaya tha 1");
        visitors.add("Fir koi aaya tha 2");
        visitors.add("Koi aata reh rha hai 3");
        visitors.add("Koi aaya tha 4");
        visitors.add("Koi aaya tha 5");
        visitors.add("Koi aaya tha 6");
        visitors.add("Koi aaya tha 7");
        visitors.add("Koi aaya tha 8");
        visitors.add("Koi aaya tha 9");

        View view = inflater.inflate(R.layout.fragment_visitors, container, false);
//        TextView tvCount = view.findViewById(R.id.visitors_count);
//        tvCount.setText("Total number of visitors: " + visitors.size());

        ListView visitorsList = view.findViewById(R.id.visitors_list);
        visitorsList.setAdapter(new ArrayAdapter <>(getContext(), android.R.layout.simple_list_item_1, visitors));
        return view;
    }
}
