package com.example.seg_androidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.seg_androidproject.Clinics.Employee;
import com.example.seg_androidproject.DataBase.DataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EmployeeLogin extends AppCompatActivity {
    private String userName;
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        userName = intent.getStringExtra("userName");
        DataBase dataBase = new DataBase(this);
        employee = dataBase.getEmployee(userName);
        String address = employee.getAddress();
        int phoneNum = employee.getPhoneNum();
        String nameOfClinic = employee.getNameOfClinic();
        String insurance = employee.getInsuranceTypes();
        String paymentMethod = employee.getPaymentMethod();
        String workingHour = employee.getWorkingHours();
        TextView textView = (TextView)findViewById(R.id.textView5);
        TextView welcome = (TextView)findViewById(R.id.textView17);
        TextView profiles = (TextView)findViewById(R.id.textView16);
        welcome.setText("Welcome " + name + "!\n");
        textView.setText("You are logged in as employee.");
        profiles.setText("\nYour address is " + address + ".\nYour phone number is " + phoneNum + ".\nYour name of the clinic is " + nameOfClinic + "." +
                "\nYour insurance type is " + insurance + ".\nYour payment method is " + paymentMethod +
                "\nYour working hours are " + workingHour);
    }

    public void editProfileOnClick(View view){
        Intent intent = new Intent(this, editEmployeeProfiles.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
        finish();
    }

    public void EYSOnClick(View view){
        Intent intent = new Intent(this, EditServicesEmployee.class);
        intent.putExtra("userName", userName);
        startActivity(intent);
    }

    public void SYSOnClick(View view){
        DataBase dataBase = new DataBase(this);
        ArrayList<String> services = dataBase.showService(employee.getName());
        String service = "";
        for(int i = 0; i < services.size(); i++){
            service += i+1;
            service += ". ";
            if(i != services.size()){
                service += services.get(i);
                service += "\n";
            }
            else{
                service += services.get(i);
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String name = employee.getName();
        builder.setTitle("All the services provided by " + name);
        builder.setMessage(service);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface arg0, int arg1){}
        });
        AlertDialog b = builder.create();
        b.show();
    }
    public void setWorkingHours(View view){
        final DataBase dataBase = new DataBase(this);
        LayoutInflater li = LayoutInflater.from(this);
        View SworkingHour = li.inflate(R.layout.set_working_hours, null);

        //final CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);
        //calendarView.isSelected();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setView(SworkingHour);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                CalendarView calendarView = (CalendarView)findViewById(R.id.calendarView);
                //long currentDate = new Date().getTime();
                calendarView.setDate(new Date().getTime());
                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth){
                        String date = year + "年" + month + "月" + dayOfMonth + "日";
                        Toast.makeText(getApplicationContext(), date, Toast.LENGTH_LONG).show();
                    }
                });
/*
                ArrayList<String> days = new ArrayList<>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
                if(!days.contains(date.getText().toString())){
                    Toast.makeText(EmployeeLogin.this, "Invalid date", Toast.LENGTH_LONG).show();
                    finish();
                    return;
                }

                String workingHour = date.getText().toString() +
                dataBase.update("Employee", "userName", userName, "workingHour", );

 */
            }
        });
        AlertDialog b = alertDialogBuilder.create();
        b.show();
    }
}
