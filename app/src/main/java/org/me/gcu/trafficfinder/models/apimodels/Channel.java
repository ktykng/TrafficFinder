package org.me.gcu.trafficfinder.models.apimodels;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    private String Title;
    private String Description;
    private String Link;
    private int Ttl;
    private ArrayList<ChannelItem> ChannelItems;



    // Empty Constructor
    public Channel() {
        Title = "";
        Description = "";
        Link = "";
        Ttl = 0;
        ChannelItems = new ArrayList<ChannelItem>();
    }

    // Overloaded Constructor
    public Channel(String title, String description, String link, int ttl, ArrayList<ChannelItem> channelItems){
        Title = title;
        Description = description;
        Link = link;
        Ttl = ttl;
        ChannelItems = channelItems;
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

    public int getTtl() {
        return Ttl;
    }

    public void setTtl(int ttl) {
        Ttl = ttl;
    }

    public List<ChannelItem> getChannelItems() {
        return ChannelItems;
    }

    public void setChannelItems(ArrayList<ChannelItem> channelItems) {
        ChannelItems = channelItems;
    }


    // Methods
    public void addItem(ChannelItem item){
        ChannelItems.add(item);
    }
}
