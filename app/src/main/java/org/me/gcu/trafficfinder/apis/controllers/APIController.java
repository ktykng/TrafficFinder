package org.me.gcu.trafficfinder.apis.controllers;

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





    public void getPlannedRoadWorks(SourceViewRequest viewRequest){
        HttpGetRequest getRequest = new HttpGetRequest();
        AsyncTaskCallInput input = new AsyncTaskCallInput(
                AsyncTaskCallUrlType.TrafficScotland_PlannedRoadworks,
                plannedRoadWorksUrl,
                viewRequest
        );

        APIModel model = new APIModel( new Channel(), input );
        getRequest.execute(model);
    }


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
