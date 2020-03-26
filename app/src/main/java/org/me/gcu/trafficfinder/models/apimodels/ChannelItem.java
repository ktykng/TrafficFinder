package org.me.gcu.trafficfinder.models.apimodels;

import com.google.android.gms.maps.model.LatLng;

import java.util.Calendar;
import java.util.Date;

public class ChannelItem {

    private String Title;
    private String Description;
    private String Link;
    private Coordinates Coordinates;
    private Date DatePublished;
    private Date StartDate;
    private Date EndDate;


    // Empty Constructor
    public ChannelItem() {
        Title = "";
        Description = "";
        Link = "";
        Coordinates = new Coordinates();

        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        DatePublished = today.getTime();
        StartDate = today.getTime();
        EndDate = today.getTime();
    }


    // Overloaded Constructor
    public ChannelItem(String title,
                                      String description,
                                      String link,
                                      Coordinates coordinates,
                                      Date datePublished,
                                      Date startDate,
                                      Date endDate)
    {
        Title = title;
        Description = description;
        Link = link;
        Coordinates = coordinates;
        DatePublished = datePublished;
        StartDate = startDate;
        EndDate = endDate;
    }




    // Getters and Setters
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public LatLng getCoordinates() {
        return Coordinates.getCoordinates();
    }

    public void setCoordinates(double latitude, double longitude) {
        Coordinates = new Coordinates(latitude, longitude);
    }

    public Date getDatePublished() {
        return DatePublished;
    }

    public void setDatePublished(Date datePublished) {
        DatePublished = datePublished;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }
}

