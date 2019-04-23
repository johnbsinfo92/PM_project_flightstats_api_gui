package com.example.jhonn.pm_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class FlightsNearFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //setContentView(R.layout.airlines_fragment);

        final View view = inflater.inflate(R.layout.flights_near_fragment, container, false);
        Button flightsNearBtn = (Button) view.findViewById(R.id.btn_look_flights_near);

        flightsNearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentMapsActivity;
                intentMapsActivity = new Intent(getActivity(),MapsActivity.class);
                intentMapsActivity.putExtra("flightsNear",true);
                System.out.println("lol");
                System.out.println("lo2");
                startActivity(intentMapsActivity);
            }
        });
        return view;
    }
}
