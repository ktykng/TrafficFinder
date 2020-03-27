//Name: Katie King
//Matriculation No.: S1827986
// async task call input class, getting the URL type
//made 26/03/2020

package org.me.gcu.trafficfinder.models.apimodels;

//imports
import org.me.gcu.trafficfinder.models.enums.AsyncTaskCallUrlType;
import org.me.gcu.trafficfinder.models.enums.SourceViewRequest;

public class AsyncTaskCallInput {

    //private variables
    private AsyncTaskCallUrlType type;
    private String url;
    private SourceViewRequest viewRequest;

    // Overloaded Constructor
    public AsyncTaskCallInput(AsyncTaskCallUrlType Type, String Url, SourceViewRequest ViewRequest){
        type = Type;
        url = Url;
        viewRequest = ViewRequest;
    }

    //getter, getting the URL type
    public AsyncTaskCallUrlType getUrlType(){ return type; }

    //setter
    public String getUrl(){
        return url;
    }
}
