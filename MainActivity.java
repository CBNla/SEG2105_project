package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import com.example.seg_androidproject.Clinics.Admin;
import com.example.seg_androidproject.Clinics.Clients;
import com.example.seg_androidproject.Clinics.Employee;
import com.example.seg_androidproject.DataBase.DataBase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase dataBase = new DataBase(this);
    }

    public void loginOnClick(View view){
        EditText userName = (EditText)findViewById(R.id.userName);
        EditText password = (EditText)findViewById(R.id.password);

        DataBase dataBase  = new DataBase(this);
        Clients client = dataBase.clientExist(userName.getText().toString(), password.getText().toString());
        Employee employee = dataBase.employeeExist(userName.getText().toString(), password.getText().toString());
        Admin admin = dataBase.adminExist(userName.getText().toString(), password.getText().toString());

        if (client == null && employee == null && admin == null){
            Intent intent = new Intent(this, LoginFailed.class);
            startActivity(intent);
        }
        else if(client != null){
            String name = client.getName();
            Intent intent = new Intent(this, ClientLogin.class);
            intent.putExtra("Name", name);
            startActivity(intent);

        }
        else if(employee!= null){
            String name = employee.getName();
            Intent intent = new Intent(this, EmployeeLogin.class);
            intent.putExtra("Name", name);
            startActivity(intent);
        }
        else if(admin != null){
            String name = admin.getName();
            Intent intent = new Intent(this, AdminLogin.class);
            intent.putExtra("Name", name);
            startActivity(intent);
        }
    }

    public void createOnClick(View view) {
        Intent intent = new Intent(this, EmployeeORClient.class);
        startActivity(intent);
    }
}
