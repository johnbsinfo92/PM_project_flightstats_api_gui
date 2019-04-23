package com.example.jhonn.pm_project;



import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FlightStatsCalls {

    String appId = "23149a1a";
    String appKey = "ae9747c131d7705088658e2212fec86c";

    /*public ArrayList<Location> flightsNear(String currentLat,String currentLong,Context context){
        String LatQuemado = "10.3455527";
        String LongQuemado = "-84.4333861";
        String RadiusQuemado = "25";
        String URL = "https://api.flightstats.com/flex/flightstatus/rest/v2/json/flightsNear/" +
                LatQuemado + "/" + LongQuemado + "/" + RadiusQuemado + "?"
                +"appId= " + appId + "&appKey= " + appKey + "&maxFlights=5&sourceType=derived";

        final ArrayList<Location> flightsNear = new ArrayList<>();

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        JSONObject jsonObject;
                        JSONArray jsonArrayPositions;
                        String name = "";
                        try {

                            jsonObject = new JSONObject(response);
                            jsonArrayPositions = jsonObject.getJSONArray("flightPositions");
                            jsonObject = jsonArrayPositions.getJSONObject(4);
                            jsonArrayPositions = jsonObject.getJSONArray("positions");

                            Log.d("sa123" + getClass().getName(), "TEST BABOSO");

                            for (int i = 0; i < jsonArrayPositions.length() - 1; i++) {
                                JSONObject jsonObj = jsonArrayPositions.getJSONObject(i);
                                Location loca = new Location(jsonObj.getString("lat"),jsonObj.getString("lon"));
                                flightsNear.add(loca);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Log.e("ERROR FLIGHTSNEAR", "onErrorResponse: ",error );
                    }
                });

        RequestQueue queque = Volley.newRequestQueue(context);
        queque.add(request);
        return flightsNear;
    }*/
}
