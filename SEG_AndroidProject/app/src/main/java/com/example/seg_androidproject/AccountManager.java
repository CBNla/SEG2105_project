package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

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

    public void cancleOnClick(View view){
        finish();
    }

    public void fOnClick(View view){
        delete = (RadioButton)findViewById(R.id.deleteBtn);
        create = (RadioButton)findViewById(R.id.createBtn);
        employee = (RadioButton)findViewById(R.id.employeeBtn);
        client = (RadioButton)findViewById(R.id.clientBtn);
        DataBase dataBase = new DataBase(this);
        if(delete.isChecked()){
            EditText userName = (EditText)findViewById(R.id.UserName);
            if(userName.getText().toString().equals("")){
                Toast.makeText(AccountManager.this, "You haven't enter user name", Toast.LENGTH_LONG).show();
                finish();
            }
            else if(employee.isChecked()){
                dataBase.remove("Employee", userName.getText().toString());
                Toast.makeText(AccountManager.this, "Success!!!", Toast.LENGTH_LONG).show();
                finish();
            }
            else if(client.isChecked()){
                dataBase.remove("Client", userName.getText().toString());
                Toast.makeText(AccountManager.this, "Success!!!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
        else if(create.isChecked()){
            Intent intent = new Intent(this, EmployeeORClient.class);
            startActivity(intent);
            finish();
        }
    }
}
