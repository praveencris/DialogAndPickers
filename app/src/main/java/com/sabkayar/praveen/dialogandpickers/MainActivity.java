package com.sabkayar.praveen.dialogandpickers;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openTimePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Toast.makeText(MainActivity.this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
            }
        }, hour, minute, false);

        //Set Title to Time Picker Dialog
        timePickerDialog.setMessage("Set Time");

        timePickerDialog.show();
    }

    public void openDatePicker(View view) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog.OnDateSetListener onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Toast.makeText(MainActivity.this, dayOfMonth + "/" + ++month + "/" + year, Toast.LENGTH_SHORT).show();
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, onDateSetListener,
                year, month, day);
        long currentTime = System.currentTimeMillis();
        long secondsInOneYear = 365 * 24 * 60 * 60;
        long milliSecondsInYear = secondsInOneYear * 1000;
        long oneYearBefore = currentTime - milliSecondsInYear;
        long oneYearAfter = currentTime + milliSecondsInYear;

        //Set Min and Max date for date Picker
        datePickerDialog.getDatePicker().setMinDate(oneYearBefore);
        datePickerDialog.getDatePicker().setMaxDate(oneYearAfter);
        //Set Message a title for date picker
        datePickerDialog.setMessage("Select Date");
        datePickerDialog.show();
    }

    public void openAlertDialog(View view) {
    }
}