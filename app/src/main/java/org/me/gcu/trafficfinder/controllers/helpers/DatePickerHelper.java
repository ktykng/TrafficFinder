//Name: Katie King
//Matriculation No.: S1827986
//Date picker helper, made 26/03/2020

package org.me.gcu.trafficfinder.controllers.helpers;

//Imports
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.textfield.TextInputEditText;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DatePickerHelper {

    //Private variables
    private TextInputEditText _dateInput;
    private long _today;
    private long _startDate;
    private long _endDate;
    private Calendar _calendar;
    private final String _dateFormatString = "MMM dd, yyyy";

    public DatePickerHelper(TextInputEditText dateInput){
        _dateInput = dateInput;
    }


    public MaterialDatePicker build(){
        _dateInput.setKeyListener(null);


        // Calendar set
        _calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        _startDate = _calendar.getTimeInMillis();
        _calendar.roll(Calendar.MONTH,1);
        _endDate = _calendar.getTimeInMillis();

        // Calendar Constraints
        CalendarConstraints.Builder constraintBuilder = new CalendarConstraints.Builder();
        constraintBuilder.setStart(_startDate);
        constraintBuilder.setEnd(_endDate);

        // start the builder for the date picker
        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Enter a date");
        builder.setCalendarConstraints(constraintBuilder.build());
        builder.setSelection(_startDate);


        // Build the Picker
        final MaterialDatePicker materialDatePicker = builder.build();

        return materialDatePicker;
    }

    //Today method, formatting and setting the date to today's date.
    public String today(){
        SimpleDateFormat dateFormat = new SimpleDateFormat(_dateFormatString);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date today = Calendar.getInstance().getTime();
        return dateFormat.format(today);
    }


    public boolean validate(long dateToValidate){
        return dateToValidate > _startDate;
    }


}

