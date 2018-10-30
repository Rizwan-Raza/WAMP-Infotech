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
import com.wampinfotech.wampinfotech.modals.TechModal;
import com.wampinfotech.wampinfotech.utils.CircleTransformation;

import java.util.ArrayList;

/**
 * {@link TechCardAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link TechModal} objects.
 */
public class TechCardAdapter extends ArrayAdapter <TechModal> {

    /**
     * Create a new {@link TechCardAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param techs   is the list of {@link TechModal}s to be displayed.
     */
    public TechCardAdapter(Context context, ArrayList <TechModal> techs) {
        super(context, 0, techs);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View gridView = convertView;
        if (gridView == null) {
            gridView = LayoutInflater.from(getContext()).inflate(
                    R.layout.technoloy_card, parent, false);
        }

        // Get the {@link ServiceCard} object located at this position in the list
        TechModal currentTech = getItem(position);

        // Find the TextView in the service_card.xml layout with the ID service_card_title.
        TextView titleTextView = gridView.findViewById(R.id.tech_title);
        // Get the Title from the currentService object and set this text on
        // the Title TextView.
        titleTextView.setText(currentTech != null ? currentTech.getTitle() : null);
//        titleTextView.setTag(currentService != null ? currentService.getTitle() : null);

//        ImageView iconView = listItemView.findViewById(R.id.service_card_icon);
//        iconView.setImageResource(currentTech.getIcon());

        final ImageView imageView = gridView.findViewById(R.id.tech_image);
        if (currentTech != null) {
            Picasso.get()
                    .load(currentTech.getImageUrl())
                    .placeholder(R.drawable.ic_code_black_24dp) // can also be a drawable
                    .error(R.drawable.ic_perm_scan_wifi_black_24dp) // will be displayed if the image cannot be loaded
                    .noFade()
                    .transform(new CircleTransformation())
                    .into(imageView, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError(Exception ex) {
                            imageView.setScaleX(0.5f);
                            imageView.setScaleY(0.5f);
                        }
                    });
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return gridView;
    }
}