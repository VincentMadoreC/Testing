package com.example.vincent.testing;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimeSelector {

    public static void showDateSelector(View view) {
        final View v = view;

        Calendar calendar = Calendar.getInstance();
        int cYear = calendar.get(Calendar.YEAR);
        int cMonth = calendar.get(Calendar.MONTH);
        int cDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month += 1; // Months go from 0 to 11
                String date = FormatInput.dateYMD(year + "-" + month + "-" + day);
                ((EditText) v).setText(date);
            }
        }, cYear, cMonth, cDay);
        datePicker.show();
    }

    /**
     * Display a clock that allows to select a time and put it in the EditText field
     * @param view
     */
    public static void showTimePicker(View view) {
        // From https://stackoverflow.com/questions/17901946/timepicker-dialog-from-clicking-edittext
        // and https://developer.android.com/reference/java/util/Calendar
        // and https://developer.android.com/reference/android/app/TimePickerDialog
        final View v = view;

        Calendar calendar = Calendar.getInstance();
        int cHour = calendar.get(Calendar.HOUR_OF_DAY);
        int cMinute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePicker = new TimePickerDialog(v.getContext(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                String fullTime = hour + ":" + minute;

                ((EditText) v).setText(fullTime);
            }
        }, cHour, cMinute, true);
        timePicker.show();
    }
}
