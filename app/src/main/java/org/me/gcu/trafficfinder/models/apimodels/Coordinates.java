package org.me.gcu.trafficfinder.models.apimodels;

import  com.google.android.gms.maps.model.LatLng;

public class Coordinates {
    private double Latitude;
    private double Longitude;

    public Coordinates(){
        Latitude = 0;
        Longitude = 0;
    }

    public Coordinates(double latitude, double longitude){
        Latitude = latitude;
        Longitude = longitude;
    }

    public LatLng getCoordinates() {return new LatLng(Latitude, Longitude);}
}
