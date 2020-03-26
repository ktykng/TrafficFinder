package org.me.gcu.trafficfinder.controllers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import org.me.gcu.trafficfinder.R;
import org.me.gcu.trafficfinder.models.viewmodels.TodayViewModel;

public class TodayFragment extends Fragment {

    private TodayViewModel todayViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        todayViewModel =
//                ViewModelProviders.of(this).get(TodayViewModel.class);
        View root = inflater.inflate(R.layout.fragment_today, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
//        todayViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}