package com.wampinfotech.wampinfotech.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wampinfotech.wampinfotech.R;
import com.wampinfotech.wampinfotech.modals.TeamModal;
import com.wampinfotech.wampinfotech.modals.TechModal;
import com.wampinfotech.wampinfotech.utils.CircleTransformation;

import java.util.ArrayList;

/**
 * {@link TeamCardAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link TechModal} objects.
 */
public class TeamCardAdapter extends ArrayAdapter <TeamModal> {

    /**
     * Create a new {@link TeamCardAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param team    is the list of {@link TechModal}s to be displayed.
     */
    public TeamCardAdapter(Context context, ArrayList <TeamModal> team) {
        super(context, 0, team);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View gridView = convertView;
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(
                    R.layout.team_card, parent, false);
        }

        // Get the {@link ServiceCard} object located at this position in the list
        TeamModal currentMember = getItem(position);

        // Find the TextView in the service_card.xml layout with the ID service_card_title.
        TextView titleTextView = gridView.findViewById(R.id.ab_tm_name);
        // Get the Title from the currentService object and set this text on
        // the Title TextView.
        titleTextView.setText(currentMember != null ? currentMember.getTitle() : null);
//        titleTextView.setTag(currentService != null ? currentService.getTitle() : null);

        TextView descTextView = gridView.findViewById(R.id.ab_tm_desc);
        descTextView.setText(currentMember != null ? currentMember.getDesc() : null);


//        ImageView iconView = listItemView.findViewById(R.id.service_card_icon);
//        iconView.setImageResource(currentTech.getIcon());

        final ImageView imageView = gridView.findViewById(R.id.ab_tm_avatar);
        if (currentMember != null) {
//            Log.e("RexTerminous", currentMember.getImageUrl());
            Picasso.get()
                    .load(currentMember.getImageUrl())
                    .transform(new CircleTransformation())
                    .into(imageView);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return gridView;
    }
}