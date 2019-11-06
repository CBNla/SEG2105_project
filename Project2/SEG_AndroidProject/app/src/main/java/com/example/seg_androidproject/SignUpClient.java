package com.example.seg_androidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.seg_androidproject.Clinics.Clients;
import com.example.seg_androidproject.DataBase.DataBase;

public class SignUpClient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_client);
    }

    public void doneOnClick(View view){
        final DataBase dataBase = new DataBase(this);
        final Clients client = new Clients();

        EditText userName = (EditText) findViewById(R.id.UserName);
        EditText password = (EditText) findViewById(R.id.Password);
        EditText name = (EditText) findViewById(R.id.Name);
        EditText age = (EditText) findViewById(R.id.Age);
        String userNameS = userName.getText().toString();
        String passwordS = password.getText().toString();
        String nameS = name.getText().toString();
        String ageS = age.getText().toString();

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
            if(dataBase.cExist(userNameS)){
                Intent intent = new Intent(this, InvalidInfoE.class);
                startActivity(intent);
            }
            else{
                client.setUserName(userName.getText().toString());
                client.setPassword(password.getText().toString());
                client.setName(name.getText().toString());
                dataBase.insertClient(client);
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
        }
    }
}
