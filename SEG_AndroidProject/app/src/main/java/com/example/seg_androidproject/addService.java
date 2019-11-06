package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.seg_androidproject.Clinics.Clinic;
import com.example.seg_androidproject.DataBase.DataBase;

public class addService extends AppCompatActivity {
    private RadioButton nurse;
    private RadioButton doctor;
    private RadioButton staff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
    }

    public void cancleOnClick(View view){
        Intent intent = new Intent(this, AdminLogin.class);
        startActivity(intent);
    }

    public void finishOnClick(View view){
        nurse = (RadioButton)findViewById(R.id.nurseBtn);
        doctor = (RadioButton)findViewById(R.id.doctorBtn);
        staff = (RadioButton)findViewById(R.id.staffBtn);
        Clinic clinic = new Clinic();
        EditText userInput = (EditText)findViewById(R.id.addText);
        if(userInput.getText() == null){
            Toast.makeText(addService.this, "You haven't input any service", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
        }
        else if(nurse.isChecked()){
            boolean success = clinic.addService(userInput.getText().toString(), " by nurse");
            if(success){
                Toast.makeText(addService.this, "Success!!!", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(addService.this, "This service has exist", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
        }
        else if(doctor.isChecked()){
            boolean success = clinic.addService(userInput.getText().toString(), " by doctor");
            if(success){
                Toast.makeText(addService.this, "Success!!!", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(addService.this, "This service has exist", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
        }
        else if(staff.isChecked()){
            boolean success = clinic.addService(userInput.getText().toString(), " by staff");
            if(success){
                Toast.makeText(addService.this, "Success!!!", Toast.LENGTH_LONG).show();
            }
            else{
                Toast.makeText(addService.this, "This service has exist", Toast.LENGTH_LONG).show();
            }
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(addService.this, "You didn't choose any role for this service", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, AdminLogin.class);
            startActivity(intent);
        }
    }
}
