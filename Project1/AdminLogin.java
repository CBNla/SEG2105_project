package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        TextView textView = (TextView)findViewById(R.id.textView5);
        textView.setText("Welcome " + name + "! You are logged in as Admin");
    }
}
