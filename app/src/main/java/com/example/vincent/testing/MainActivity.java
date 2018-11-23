package com.example.vincent.testing;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TimePicker timePicker1;
    EditText eReminderDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        EditText time = (EditText) findViewById(R.id.time);
//        time.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//        eReminderDate = (EditText) findViewById(R.id.time);
//        eReminderDate.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                //To show current date in the datepicker
//                Calendar mcurrentDate = Calendar.getInstance();
//                int mYear = mcurrentDate.get(Calendar.YEAR);
//                int mMonth = mcurrentDate.get(Calendar.MONTH);
//                int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//
//                DatePickerDialog mDatePicker;
//                mDatePicker = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
//                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                        // TODO Auto-generated method stub
//                        /*      Your code   to get date and time    */
//                        selectedmonth = selectedmonth + 1;
//                        eReminderDate.setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
//                    }
//                }, mYear, mMonth, mDay);
//                mDatePicker.setTitle("Select Date");
//                mDatePicker.show();
//            }
//        });
    }

    public void onClickValidateButton(View view) {
        ViewGroup vg = findViewById(R.id.root);
        if(!Validation.validateAll(vg)) {
            return;
        }

        EditText email = findViewById(R.id.EmailField);
        EditText emailConf = findViewById(R.id.EmailConf);
        EditText password = findViewById(R.id.PasswordField);
        EditText passwordConf = findViewById(R.id.PasswordConf);
        if(!Validation.confirmField(email, emailConf, "email")) {
            return;
        }
        if(!Validation.confirmField(password, passwordConf, "password")) {
            return;
        }

//        if (!email.equals(emailConf)) {
//            Toast errorMessage = Toast.makeText(this, "Email does not match.", Toast.LENGTH_LONG);
//            return false;
//        }
//        EditText textField = findViewById(R.id.NameField);
//        Validation.validateName(textField);
    }

    public void onClickGo(View view) {
        Intent intent = new Intent(this, SecondaryActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Closing Activity")
                .setMessage("Are you sure you want to close this activity?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }


    public void showTimePickerDialog(View view) {
        // From https://stackoverflow.com/questions/17901946/timepicker-dialog-from-clicking-edittext
        // and https://developer.android.com/reference/java/util/Calendar
        // and https://developer.android.com/reference/android/app/DatePickerDialog
        final View v = view;

        Calendar calendar = Calendar.getInstance();
        int cYear = calendar.get(Calendar.YEAR);
        int cMonth = calendar.get(Calendar.MONTH);
        int cDay = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePicker = new DatePickerDialog(view.getContext(), new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month += 1; // Months go from 0 to 11
                ((EditText) v).setText(year + "-" + month + "-" + day);
            }
        }, cYear, cMonth, cDay);
        datePicker.show();



//        Calendar mcurrentDate = Calendar.getInstance();
//        int mYear = mcurrentDate.get(Calendar.YEAR);
//        int mMonth = mcurrentDate.get(Calendar.MONTH);
//        int mDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
//        DatePickerDialog mDatePicker;
//
//        mDatePicker = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
//            public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
//                selectedmonth = selectedmonth + 1;
//                ((EditText) view).setText("" + selectedday + "/" + selectedmonth + "/" + selectedyear);
//            }
//        }, mYear, mMonth, mDay);
//        mDatePicker.setTitle("Select Date");
//        mDatePicker.show();


    }

    public void showTimePicker(View view) {
        // From https://stackoverflow.com/questions/17901946/timepicker-dialog-from-clicking-edittext
        // and https://developer.android.com/reference/java/util/Calendar
        // and https://developer.android.com/reference/android/app/DatePickerDialog
        TimeSelector.showTimePicker(view);

    }



    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        EditText time = findViewById(R.id.time);
        if (getCurrentFocus() != null) {
            time.setText(hour + ":" + minute);
        }
    }



}
