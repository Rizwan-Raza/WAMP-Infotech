package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.ServiceCard;

import java.util.ArrayList;

/**
 * {@link ServiceCardAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link ServiceCard} objects.
 */
public class ServiceCardAdapter extends ArrayAdapter <ServiceCard> {

    /**
     * Create a new {@link ServiceCardAdapter} object.
     *
     * @param context  is the current context (i.e. Activity) that the adapter is being created in.
     * @param services is the list of {@link ServiceCard}s to be displayed.
     */
    public ServiceCardAdapter(Context context, ArrayList <ServiceCard> services) {
        super(context, 0, services);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.service_card, parent, false);
        }

        // Get the {@link ServiceCard} object located at this position in the list
        ServiceCard currentService = getItem(position);

        // Find the TextView in the service_card.xml layout with the ID service_card_title.
        TextView titleTextView = listItemView.findViewById(R.id.service_card_title);
        // Get the Title from the currentService object and set this text on
        // the Title TextView.
        titleTextView.setText(currentService != null ? currentService.getTitle() : null);
//        titleTextView.setTag(currentService != null ? currentService.getTitle() : null);

        ImageView iconView = listItemView.findViewById(R.id.service_card_icon);
        iconView.setImageResource(currentService.getIcon());


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}