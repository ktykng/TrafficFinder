package org.me.gcu.trafficfinder.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.me.gcu.trafficfinder.R;

import java.util.List;

public class SearchFragment extends Fragment implements OnMapReadyCallback {

    private View root;
    private GoogleMap map;
    private MapView mapView;
    private TextInputEditText searchForRoadText;
    private List<AutocompletePrediction> predictionList;
    private FusedLocationProviderClient mFusedLocationProviderClient;
    private PlacesClient placesClient;
    private AutoCompleteTextView filterText;
    private Button submitButton;
    private TextInputLayout filterLayout;
    private TextInputLayout searchForRoadLayout;
    private LatLng searchedLatLong;

    private SearchViewModel searchViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_search, container, false);
        filterLayout = root.findViewById(R.id.look_filter_layout);
        filterText = root.findViewById(R.id.look_filter_field);
        searchForRoadLayout = root.findViewById(R.id.look_search_layout);
        searchForRoadText = root.findViewById(R.id.look_search_field);
        submitButton = root.findViewById(R.id.look_search_submit);

        String[] filterArray = new String[] {"Roadwork", "Current Incident"};

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        getContext(),
                        R.layout.dropdown_menu_popup_item,
                        filterArray);

        filterText.setAdapter(adapter);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm(v);
            }
        });

        MapsInitializer.initialize(this.getActivity());
        mapView = root.findViewById(R.id.look_map_view);
        mapView.onCreate(savedInstanceState);


        return root;
    }

    private void submitForm(View root){

    }

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