//Name: Katie King
//Matriculation No.: S1827986
//Today's Traffic Page Controller, made 24/03/2020


package org.me.gcu.trafficfinder.controllers;

//imports
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import org.me.gcu.trafficfinder.R;
import org.me.gcu.trafficfinder.apis.controllers.APIController;
import org.me.gcu.trafficfinder.controllers.helpers.DatePickerHelper;
import org.me.gcu.trafficfinder.models.apimodels.APIModel;
import org.me.gcu.trafficfinder.models.apimodels.ChannelItem;
import org.me.gcu.trafficfinder.models.enums.AsyncTaskCallUrlType;
import org.me.gcu.trafficfinder.models.enums.SourceViewRequest;
import org.me.gcu.trafficfinder.models.interfaces.AsyncResponse;
import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends Fragment implements AsyncResponse {

    //private variables
    private TextInputEditText dateInput;
    private TextInputLayout dateInputLayout;
    private ConstraintLayout constraintLayout;
    private RecyclerView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;
    private ListView listView;
    private TodayFragment todayFragment = this;
    private String selectedDateString;
    private ArrayList<ChannelItem> requestModels = new ArrayList<>();




    public View onCreateView(@NonNull LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        // region Call Traffic Scotland Controller to get Current Incidents
        APIController controller = new APIController();
        SourceViewRequest request = SourceViewRequest.Today;
        controller.getRoadWorks(request, this);
        controller.getCurrentIncidents(request, this);

        // endregion



        // region Find all Views By Id
        View root = inflater.inflate(R.layout.fragment_today, container, false);
        dateInput = root.findViewById(R.id.today_date_field);
        dateInputLayout = root.findViewById(R.id.today_date_layout);
        constraintLayout = root.findViewById(R.id.today_constraint_layout);
        listView = root.findViewById(R.id.today_list_view);

        // endregion


        // region Date Picker Instantiation
        final DatePickerHelper dpHelper = new DatePickerHelper(dateInput);
        final MaterialDatePicker dp = dpHelper.build();
        dateInput.setText(dpHelper.today());


        dateInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.show(getFragmentManager(), "DATE_PICKER");
            }
        });


        dp.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                if (dpHelper.validate(Long.parseLong(selection.toString()))) {
                    selectedDateString = dp.getHeaderText();
                    dateInput.setText(selectedDateString);

                    APIController controller = new APIController();
                    SourceViewRequest viewRequest = SourceViewRequest.Today;
                    if (!dateInput.getText().toString().equals(dpHelper.today())) {
                        // Any future dates
                        controller.getPlannedRoadWorks(viewRequest, todayFragment);
                    } else {
                        // Today
                        controller.getRoadWorks(viewRequest, todayFragment);
                        controller.getCurrentIncidents(viewRequest, todayFragment);
                    }
                } else {
                    Toast toast = Toast.makeText(getContext(),
                            "Please do not select a date in the past",
                            Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });
         //endregion
        return root;
    }


    @Override
    public void processFinish(APIModel output) {

        for(ChannelItem item : output.getChannel().getChannelItems()){
            item.setType(output.getInput().getUrlType());
            requestModels.add(item);
        }

        if(output.getInput().getUrlType() != AsyncTaskCallUrlType.TrafficScotland_Roadworks){
            // If all requests have been completed, display all requests to the view
            // There can be a max of 2 requests, one from the output and one from the tempModel

            ListAdapter adapter = new ListAdapter(this.getContext(), requestModels);
            listView.setAdapter(adapter);
            requestModels = new ArrayList<>();
        }
    }


    class ListAdapter extends ArrayAdapter<ChannelItem> {

        //private variables
        private Context context;
        private List<ChannelItem> allItems;

        ListAdapter (Context c, ArrayList<ChannelItem> allItems) {
            super(c, R.layout.card, R.id.textView1, allItems);
            this.context = c;
            this.allItems = allItems;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.card, parent, false);
            ImageView currentImage = row.findViewById(R.id.image);
            TextView currentTitle = row.findViewById(R.id.textView1);
            TextView currentDescription = row.findViewById(R.id.textView2);
            TextView currentTypeText = row.findViewById(R.id.today_card_type_text);

            if(allItems.get(position).getType() == AsyncTaskCallUrlType.TrafficScotland_CurrentIncidents){
                currentImage.setImageResource(R.drawable.ic_local_car_wash_black_24dp);
                currentTypeText.setText("Incident");
            } else if(allItems.get(position).getType() == AsyncTaskCallUrlType.TrafficScotland_Roadworks) {
                currentImage.setImageResource(R.drawable.ic_warning_black_24dp);
                currentTypeText.setText("Roadwork");
            } else {
                currentImage.setImageResource(R.drawable.ic_traffic_black_24dp);
                currentTypeText.setText("Planned");
            }

            currentTitle.setText(allItems.get(position).getTitle());
            currentDescription.setText(allItems.get(position).getDescription());

            return row;
        }
    }

}