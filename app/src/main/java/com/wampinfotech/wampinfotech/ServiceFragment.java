
package com.wampinfotech.wampinfotech;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wampinfotech.wampinfotech.modals.ServiceCard;

import java.util.ArrayList;

public class ServiceFragment extends Fragment {

    // Create a list of services
    ArrayList <ServiceCard> services = new ArrayList <>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_services, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Services");

        services.add(new ServiceCard(getString(R.string.h_s_c_1), R.drawable.ic_color_lens_black_24dp));
        services.add(new ServiceCard(getString(R.string.h_s_c_2), R.drawable.ic_code_black_24dp));
        services.add(new ServiceCard(getString(R.string.h_s_c_3), R.drawable.ic_shopping_cart_black_24dp));
        services.add(new ServiceCard(getString(R.string.h_s_c_4), R.drawable.ic_desktop_windows_black_24dp));

    }
}