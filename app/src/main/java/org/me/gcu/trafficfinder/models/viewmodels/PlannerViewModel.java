//Name: Katie King
//Matriculation No.: S1827986
//planner view model.
//made 26/03/2020

package org.me.gcu.trafficfinder.models.viewmodels;

//imports
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlannerViewModel extends ViewModel {

    //private variables
    private MutableLiveData<String> mText;

    //planner view model method
    public PlannerViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is dashboard fragment");
    }

    //getter
    public LiveData<String> getText() {
        return mText;
    }
}