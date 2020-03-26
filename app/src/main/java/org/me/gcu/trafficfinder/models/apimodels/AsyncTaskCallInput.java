package org.me.gcu.trafficfinder.models.apimodels;

import org.me.gcu.trafficfinder.models.enums.AsyncTaskCallUrlType;
import org.me.gcu.trafficfinder.models.enums.SourceViewRequest;

public class AsyncTaskCallInput {
    private AsyncTaskCallUrlType type;
    private String url;
    private SourceViewRequest viewRequest;

    // Overloaded Constructor
    public AsyncTaskCallInput(AsyncTaskCallUrlType Type, String Url, SourceViewRequest ViewRequest){
        type = Type;
        url = Url;
        viewRequest = ViewRequest;
    }

    public AsyncTaskCallUrlType getUrlType(){ return type; }

    public String getUrl(){
        return url;
    }
}
