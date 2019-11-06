package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.seg_androidproject.Clinics.Clients;
import com.example.seg_androidproject.Clinics.Employee;
import com.example.seg_androidproject.DataBase.DataBase;

public class SignUpEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_employee);
    }

    public void doneOnClick(View view) {
        final DataBase dataBase = new DataBase(this);
        final Employee employee = new Employee();

        EditText userName = (EditText) findViewById(R.id.UserName);
        EditText password = (EditText) findViewById(R.id.Password);
        EditText name = (EditText) findViewById(R.id.Name);
        String userNameS = userName.getText().toString();
        String passwordS = password.getText().toString();
        String nameS = name.getText().toString();

        if(userNameS.equals("") && passwordS.equals("") && nameS.equals("")){
            Intent intent = new Intent(this, InvalidInfoE.class);
            startActivity(intent);
        }
        else if(userNameS.length() > 50 && passwordS.length() > 50 && nameS.length() > 50){
            Intent intent = new Intent(this, InvalidInfoE.class);
            startActivity(intent);
        }
        else {
            for(int i = 0; i < userNameS.length(); i++){
                if(!Character.isDigit(userNameS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
                else if(!Character.isLetter(userNameS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
            }
            for(int i = 0; i < passwordS.length(); i++){
                if(!Character.isDigit(passwordS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
                else if(!Character.isLetter(passwordS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
            }
            for(int i = 0; i < nameS.length(); i++){
                if(!Character.isDigit(nameS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
                else if(!Character.isLetter(nameS.charAt(i))){
                    Intent intent = new Intent(this, InvalidInfoE.class);
                    startActivity(intent);
                }
            }
            if(dataBase.eExist(userNameS)){
                Intent intent = new Intent(this, InvalidInfoE.class);
                startActivity(intent);
            }
            else{
                employee.setUserName(userName.getText().toString());
                employee.setPassword(password.getText().toString());
                employee.setName(name.getText().toString());
                dataBase.insertEmployee(employee);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
