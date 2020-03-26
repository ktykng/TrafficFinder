package org.me.gcu.trafficfinder.controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.me.gcu.trafficfinder.R;
import org.me.gcu.trafficfinder.models.viewmodels.PlannerViewModel;

import java.util.List;


public class PlannerFragment extends Fragment implements OnMapReadyCallback {

    private View root;
    private GoogleMap map;
    private MapView mapView;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private Button submitButton;
    private TextInputEditText startText;
    private TextInputEditText endText;
    private TextInputLayout startLayout;
    private TextInputLayout endLayout;
    private PlacesClient placesClient;
    private List<AutocompletePrediction> predictionList;
    private LatLng startLatLong, endLatLong, medianLatLong;
    private MarkerOptions startPlace, endPlace;
    private Polyline currentPolyline;

    private int ZOOM_LEVEL = 12;

    private PlannerViewModel plannerViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_planner, container, false);
        startLayout = root.findViewById(R.id.planner_start_layout);
        endLayout = root.findViewById(R.id.planner_end_layout);
        startText = root.findViewById(R.id.planner_start_field);
        endText = root.findViewById(R.id.planner_end_field);
        submitButton = root.findViewById(R.id.planner_search_submit);


        MapsInitializer.initialize(this.getActivity());
        mapView = root.findViewById(R.id.planner_map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync((OnMapReadyCallback) this);



        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        LatLng uk = new LatLng(54, -3);
        map.moveCamera(CameraUpdateFactory.newLatLng(uk));
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
        super.onLowMemory();
    }
}