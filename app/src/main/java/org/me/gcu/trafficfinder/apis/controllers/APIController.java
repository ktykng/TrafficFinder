//Name: Katie King
//Matriculation No.: S1827986
//Controller for the API, calls the API to get the data sets, made 26/03/2020

package org.me.gcu.trafficfinder.apis.controllers;

//imports
import org.me.gcu.trafficfinder.apis.tasks.HttpGetRequest;
import org.me.gcu.trafficfinder.controllers.PlannerFragment;
import org.me.gcu.trafficfinder.controllers.SearchFragment;
import org.me.gcu.trafficfinder.controllers.TodayFragment;
import org.me.gcu.trafficfinder.models.apimodels.APIModel;
import org.me.gcu.trafficfinder.models.apimodels.AsyncTaskCallInput;
import org.me.gcu.trafficfinder.models.apimodels.Channel;
import org.me.gcu.trafficfinder.models.enums.AsyncTaskCallUrlType;
import org.me.gcu.trafficfinder.models.enums.SourceViewRequest;

public class APIController {
    final private String currentIncidentsUrl = "https://trafficscotland.org/rss/feeds/currentincidents.aspx";
    final private String roadWorksUrl = "https://trafficscotland.org/rss/feeds/roadworks.aspx";
    final private String plannedRoadWorksUrl = "https://trafficscotland.org/rss/feeds/plannedroadworks.aspx";



    String result;

    //returns the current incidents for the todays traffic page
    public void getCurrentIncidents(SourceViewRequest viewRequest, TodayFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_CurrentIncidents,
                currentIncidentsUrl,
                viewRequest
        );


        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }

    //returns the current incidents for the search road page
    public void getCurrentIncidents(SourceViewRequest viewRequest, SearchFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_CurrentIncidents,
                currentIncidentsUrl,
                viewRequest
        );


        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }

    //returns the current incidents for the journey planner page
    public void getCurrentIncidents(SourceViewRequest viewRequest, PlannerFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_CurrentIncidents,
                currentIncidentsUrl,
                viewRequest
        );


        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }




    //returns the unplanned road works for the today's traffic page
    public void getRoadWorks(SourceViewRequest viewRequest, TodayFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_Roadworks,
                roadWorksUrl,
                viewRequest
        );

        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }

    //returns the unplanned road works for the search road page
    public void getRoadWorks(SourceViewRequest viewRequest, SearchFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_Roadworks,
                roadWorksUrl,
                viewRequest
        );

        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }

    //returns the unplanned road works for the journey planner page
    public void getRoadWorks(SourceViewRequest viewRequest, PlannerFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_Roadworks,
                roadWorksUrl,
                viewRequest
        );

        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }





//    public void getPlannedRoadWorks(SourceViewRequest viewRequest){
//        HttpGetRequest getRequest = new HttpGetRequest();
//        AsyncTaskCallInput input = new AsyncTaskCallInput(
//                AsyncTaskCallUrlType.TrafficScotland_PlannedRoadworks,
//                plannedRoadWorksUrl,
//                viewRequest
//        );
//
//        APIModel model = new APIModel( new Channel(), input );
//        getRequest.execute(model);
//    }


    //gets the planned road works for the todays traffic page
    public void getPlannedRoadWorks(SourceViewRequest viewRequest, TodayFragment controller){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_PlannedRoadworks,
                plannedRoadWorksUrl,
                viewRequest
        );

        APIModel model = new APIModel( new Channel(), input );
        getRequest.delegate = controller;
        getRequest.execute(model);
    }


}
