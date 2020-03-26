package org.me.gcu.trafficfinder.models.interfaces;


import org.me.gcu.trafficfinder.models.apimodels.APIModel;

public interface AsyncResponse {
    void processFinish(APIModel output);
}