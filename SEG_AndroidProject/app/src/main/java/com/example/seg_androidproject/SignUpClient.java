package com.example.seg_androidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Invalid Input");
            builder.setMessage("You haven't enter any information, please try again.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface arg0, int arg1){}
            });
            AlertDialog b = builder.create();
            userName.setText("");
            password.setText("");
            name.setText("");
            age.setText("");
            b.show();
            return;
        }
        else if(userNameS.length() > 50 && passwordS.length() > 50 && nameS.length() > 50){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Invalid Input");
            builder.setMessage("The information you entered are too long, please try again.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface arg0, int arg1){}
            });
            AlertDialog b = builder.create();
            userName.setText("");
            password.setText("");
            name.setText("");
            age.setText("");
            b.show();
            return;
        }
        else {
            for(int i = 0; i <= userNameS.length()-1; i++){
                if(!Character.isDigit(userNameS.charAt(i)) && !Character.isLetter(userNameS.charAt(i))){
                    System.out.println("hhhh");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface arg0, int arg1){}
                    });
                    AlertDialog b = builder.create();
                    userName.setText("");
                    password.setText("");
                    name.setText("");
                    age.setText("");
                    b.show();
                    return;
                }
            }
            for(int i = 0; i <= passwordS.length()-1; i++){
                if(!Character.isDigit(passwordS.charAt(i)) && !Character.isLetter(passwordS.charAt(i))){
                    System.out.println("hhh");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface arg0, int arg1){}
                    });
                    AlertDialog b = builder.create();
                    userName.setText("");
                    password.setText("");
                    name.setText("");
                    age.setText("");
                    b.show();
                    return;
                }
            }
            for(int i = 0; i <= nameS.length()-1; i++){
                if(!Character.isDigit(nameS.charAt(i)) && !Character.isLetter(nameS.charAt(i))){
                    System.out.println("hh");
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface arg0, int arg1){}
                    });
                    AlertDialog b = builder.create();
                    userName.setText("");
                    password.setText("");
                    name.setText("");
                    age.setText("");
                    b.show();
                    return;
                }
            }
            for (int i = 0; i <= ageS.length()-1; i++){
                if(!Character.isDigit(ageS.charAt(i))){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface arg0, int arg1){}
                    });
                    AlertDialog b = builder.create();
                    userName.setText("");
                    password.setText("");
                    name.setText("");
                    age.setText("");
                    b.show();
                    return;
                }
            }
            if(dataBase.cExist(userNameS)){
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Invalid Input");
                builder.setMessage("This user name has exist, please try again.");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface arg0, int arg1){}
                });
                AlertDialog b = builder.create();
                userName.setText("");
                password.setText("");
                name.setText("");
                age.setText("");
                b.show();
                return;
            }
            else{
                client.setUserName(userNameS);
                client.setPassword(passwordS);
                client.setName(nameS);
                int i = Integer.parseInt(ageS);
                client.setAge(i);
                dataBase.insertClient(client);
                Toast.makeText(SignUpClient.this, "Success!!!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }
}
