//Name: Katie King
//Matriculation No.: S1827986
//today's traffic view model.
//made 26/03/2020

package org.me.gcu.trafficfinder.models.viewmodels;

//imports
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TodayViewModel extends ViewModel {

    //private variables
    private MutableLiveData<String> mText;

    //today view model method
    public TodayViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is today fragment");
    }

    //getter
    public LiveData<String> getText() {
        return mText;
    }
}