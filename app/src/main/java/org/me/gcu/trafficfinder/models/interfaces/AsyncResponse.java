//Name: Katie King
//Matriculation No.: S1827986
//api model async response interface
//made 26/03/2020

package org.me.gcu.trafficfinder.models.interfaces;

//imports
import org.me.gcu.trafficfinder.models.apimodels.APIModel;


public interface AsyncResponse {
    void processFinish(APIModel output);
}