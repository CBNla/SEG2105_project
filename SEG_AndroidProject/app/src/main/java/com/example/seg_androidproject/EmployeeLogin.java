package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Address;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.seg_androidproject.Clinics.Employee;
import com.example.seg_androidproject.DataBase.DataBase;

import java.util.ArrayList;

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
        TextView textView = (TextView)findViewById(R.id.textView5);
        TextView welcome = (TextView)findViewById(R.id.textView17);
        TextView profiles = (TextView)findViewById(R.id.textView16);
        welcome.setText("Welcome " + name + "!\n");
        textView.setText("You are logged in as employee.");
        profiles.setText("\nYour address is " + address + ".\nYour phone number is " + phoneNum + ".\nYour name of the clinic is " + nameOfClinic + ".\nYour insurance type is " + insurance + ".\nYour payment method is " + paymentMethod);
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
        ArrayList<String> services = dataBase.findService(employee.getName());
        System.out.println(services);
    }
}
