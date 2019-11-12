package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EmployeeLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        TextView textView = (TextView)findViewById(R.id.textView5);
        textView.setText("Welcome " + name + "! You are logged in as employee");
    }

    public void editProfileOnClick(View view){
        Intent intent = new Intent(this, editEmployeeProfiles.class);
        startActivity(intent);
    }
}
