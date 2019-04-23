package com.example.jhonn.pm_project;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import static com.google.gson.internal.bind.TypeAdapters.URL;

public class AirlinesFragment extends Fragment {
    private static final String URL = "https://api.flightstats.com/flex/airlines/rest/v1/json/active?" +
            "appId=23149a1a" +
            "&appKey=ae9747c131d7705088658e2212fec86c";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.airlines_fragment, container, false);
        ImageButton findButton = (ImageButton) view.findViewById(R.id.btn_find_airline);

        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        TextView textView = (TextView) view.findViewById(R.id.text_view_results);
                        JSONObject jsonObject;
                        JSONArray jsonArray;
                        String name = "";
                        try {

                            jsonObject = new JSONObject(response);
                            jsonArray = jsonObject.getJSONArray("airlines");

                            for (int i = 0; i < jsonArray.length() - 1; i++) {
                                JSONObject jsonObj = jsonArray.getJSONObject(i);
                                name =  name + i + ": " + jsonObj.getString("name") + "\n";
                            }
                            textView.setText(name);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity() , "Something went wrong", Toast.LENGTH_SHORT).show();
                    }
                });
                RequestQueue queque = Volley.newRequestQueue(getActivity());
                queque.add(request);
            }
        });
        return view;
    }

}
