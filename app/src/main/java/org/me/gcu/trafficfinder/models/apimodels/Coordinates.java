//Name: Katie King
//Matriculation No.: S1827986
//coordinates class, declares variables, creates constructors and getters/setters
//made 26/03/2020

package org.me.gcu.trafficfinder.models.apimodels;

//imports
import  com.google.android.gms.maps.model.LatLng;

public class Coordinates {

    //private variables
    private double Latitude;
    private double Longitude;

    //constructor
    public Coordinates(){
        Latitude = 0;
        Longitude = 0;
    }

    //overloaded constructor
    public Coordinates(double latitude, double longitude){
        Latitude = latitude;
        Longitude = longitude;
    }

    //getter
    public LatLng getCoordinates() {return new LatLng(Latitude, Longitude);}
}
