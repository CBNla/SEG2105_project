package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.seg_androidproject.DataBase.DataBase;

public class AccountManager extends AppCompatActivity {
    private RadioButton delete;
    private RadioButton create;
    private RadioButton employee;
    private RadioButton client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_manager);
    }

    public void fOnClick(View view){
        delete = (RadioButton)findViewById(R.id.deleteBtn);
        create = (RadioButton)findViewById(R.id.createBtn);
        employee = (RadioButton)findViewById(R.id.employeeBtn);
        client = (RadioButton)findViewById(R.id.clientBtn);
        DataBase dataBase = new DataBase(this);
        if(delete.isChecked()){
            EditText userName = (EditText)findViewById(R.id.UserName);
            if(employee.isChecked()){
                dataBase.remove("Employee", userName.getText().toString());
            }
            else if(client.isChecked()){
                dataBase.remove("Client", userName.getText().toString());
            }
        }
        else if(create.isChecked()){
            Intent intent = new Intent(this, EmployeeORClient.class);
            startActivity(intent);
        }
    }
}
