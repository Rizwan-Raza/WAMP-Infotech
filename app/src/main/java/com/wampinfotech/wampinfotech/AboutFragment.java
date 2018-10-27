
package com.wampinfotech.wampinfotech;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.wampinfotech.wampinfotech.adapters.TeamCardAdapter;
import com.wampinfotech.wampinfotech.modals.TeamModal;
import com.wampinfotech.wampinfotech.utils.ExGridView;

import java.util.ArrayList;

public class AboutFragment extends Fragment implements OnMapReadyCallback {

    ArrayList <TeamModal> team = new ArrayList <>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("About");

        //////////////////////////////////////////////////////////

        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));
        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));
        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));

        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));
        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));
        team.add(new TeamModal("S.M. Faris", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSaOETJexfA8qsjVwLxZfCJI2Anjn0BtQ08L3QOT7j8Asa8Ht7xGA", "CEO / Founder"));

        ExGridView mAppsGrid = getView().findViewById(R.id.team_grid);
        mAppsGrid.setExpanded(true);
        mAppsGrid.setAdapter(new TeamCardAdapter(this.getContext(), team));

        ////////////////////////////////////////////////////////////////

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment == null) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            mapFragment = SupportMapFragment.newInstance();

            ft.replace(R.id.map, mapFragment).commit();
        }
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Add a marker in WAMP and move the camera
        LatLng wampit = new LatLng(28.5723584, 77.2746726);
        googleMap.addMarker(new MarkerOptions().position(wampit).title("Marker in WAMP InfoTech Pvt Ltd"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(wampit, 14.0f));
    }
}