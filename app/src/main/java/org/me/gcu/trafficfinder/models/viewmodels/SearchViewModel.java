//Name: Katie King
//Matriculation No.: S1827986
//search view model.
//made 26/03/2020

package org.me.gcu.trafficfinder.models.viewmodels;

//imports
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {

    //private variables
    private MutableLiveData<String> mText;

    //search view model method
    public SearchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is search fragment");
    }

    //getter
    public LiveData<String> getText() {
        return mText;
    }
}