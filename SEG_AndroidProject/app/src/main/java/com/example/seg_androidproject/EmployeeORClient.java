package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EmployeeORClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_orclient);
    }

    public void clientOnClick(View view){
        Intent intent = new Intent(this, SignUpClient.class);
        startActivity(intent);
        finish();
    }

    public void employeeOnClick(View view){
        Intent intent = new Intent(this, SignUpEmployee.class);
        startActivity(intent);
        finish();
    }
}
