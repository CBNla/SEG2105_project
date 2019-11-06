package com.example.seg_androidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.seg_androidproject.Clinics.Clinic;

import java.util.ArrayList;
import java.util.List;

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

    public void addOnClick(View view){
        Intent intent = new Intent(this, addService.class);
        startActivity(intent);
    }

    public void editOnClick(View view){
        Intent intent = new Intent(this, editService.class);
        startActivity(intent);
    }

    public void deleteOnClick(View view){
        Intent intent = new Intent(this, deleteService.class);
        startActivity(intent);
    }

    public void servicesOnClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("All the services provided by our clinic");
        Clinic clinic = new Clinic();
        ArrayList<List> services = clinic.getServices();
        String service = "";
        for(int i = 0; i < services.size(); i++){
            service += i+1;
            service += ". ";
            if(i != services.size()){
                service += services.get(i).get(0);
                service += services.get(i).get(1);
                service += "\n";
            }
            else{
                service += services.get(i).get(0);
                service += services.get(i).get(1);
            }
        }
        builder.setMessage(service);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface arg0, int arg1){}
        });
        AlertDialog b = builder.create();
        b.show();
    }

    public void accountOnClick(View view){
        Intent intent = new Intent(this, AccountManager.class);
        startActivity(intent);
    }
}
