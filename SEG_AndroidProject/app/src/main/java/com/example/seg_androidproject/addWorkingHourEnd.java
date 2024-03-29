package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.seg_androidproject.DataBase.DataBase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class addWorkingHourEnd extends AppCompatActivity {
    private CalendarView calendarView;
    private int yearStart;
    private int year1 = 0;
    private int monthStart;
    private int month1 = 0;
    private int dayOfMonthStart;
    private int dayOfMonth1 = 0;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_working_hour_end);
        Intent intent = getIntent();
        yearStart = intent.getIntExtra("year", 0);
        monthStart = intent.getIntExtra("month", 0);
        dayOfMonthStart = intent.getIntExtra("dayOfMonth", 0);
        userName = intent.getStringExtra("userName");
        
        calendarView = (CalendarView)findViewById(R.id.calendarView2);
        if(yearStart == 0){
            calendarView.setMinDate(new Date().getTime());
            calendarView.setDate(new Date().getTime());
        }
        else {
            long currentTime = intToLongTime(yearStart, monthStart, dayOfMonthStart);
            calendarView.setMinDate(currentTime);
            calendarView.setDate(currentTime);
        }
        calendarView.setDate(new Date().getTime());
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                month += 1;
                Toast.makeText(addWorkingHourEnd.this, "Your working hour end by " + month + "/" + dayOfMonth + "/" + year, Toast.LENGTH_LONG).show();
                year1 = year;
                month1 = month;
                dayOfMonth1 = dayOfMonth;
            }
        });
    }

    public void SetEndDate(View view){
        if(yearStart == 0 || year1 == 0){
            Toast.makeText(addWorkingHourEnd.this, "You didn't choose a date, please login again.", Toast.LENGTH_LONG).show();
            finish();
        }
        else {
            String workingTime = monthStart + "/" + dayOfMonthStart + "/" + yearStart + " to " + month1 + "/" + dayOfMonth1 + "/" + year1;
            DataBase dataBase = new DataBase(this);
            //dataBase.update("Employee", "userName", userName, "workingHour", workingTime);
            Toast.makeText(addWorkingHourEnd.this, "Finish, please login again.", Toast.LENGTH_LONG).show();
            finish();
        }
    }

    private long intToLongTime(int year, int month, int dayOfMonth){
        String currentTime = month + "-" + dayOfMonth + "-" + year;
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date date = null;
        try {
            date = formatter.parse(currentTime);
        } catch (ParseException e) {
            date = null;
        }
        if(date == null){
            return new Date().getTime();
        }
        else{
            return date.getTime();
        }
    }
}
