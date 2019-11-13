package com.example.seg_androidproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.seg_androidproject.Clinics.Employee;
import com.example.seg_androidproject.DataBase.DataBase;

public class editEmployeeProfiles extends AppCompatActivity {
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_profiles);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
    }

    public void doneEditOnClick(View view){
        System.out.print(userName);
        DataBase dataBase = new DataBase(this);

        EditText name = (EditText) findViewById(R.id.nameEText);
        EditText address = (EditText) findViewById(R.id.addressEText);
        EditText phoneNum = (EditText) findViewById(R.id.phoneNumEText);
        EditText nameOfClinic = (EditText) findViewById(R.id.nameOfClinicEText);
        EditText insuranceType = (EditText) findViewById(R.id.insuranceEText);
        EditText paymentMethod = (EditText) findViewById(R.id.paymentEText);

        String nameS = name.getText().toString();
        String addressS = address.getText().toString();
        String phoneNumS = phoneNum.getText().toString();
        String nameOfClinicS = nameOfClinic.getText().toString();
        String insuranceS = insuranceType.getText().toString();
        String paymentS = paymentMethod.getText().toString();

        if(nameS.length() > 50 || addressS.length() > 50 || phoneNumS.length() > 10 || nameOfClinicS.length() > 50 || insuranceS.length() > 50 || paymentS.length() > 50){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Invalid Input");
            builder.setMessage("The information you entered are too long, please try again.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface arg0, int arg1){}
            });
            AlertDialog b = builder.create();
            name.setText("");
            address.setText("");
            phoneNum.setText("");
            insuranceType.setText("");
            nameOfClinic.setText("");
            paymentMethod.setText("");
            b.show();
            return;
        }

        if(!nameS.equals("")) {
            for (int i = 0; i <= nameS.length() - 1; i++) {
                if (!Character.isDigit(nameS.charAt(i)) && !Character.isLetter(nameS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "name", nameS);
        }
        if(!addressS.equals("")) {
            for (int i = 0; i <= addressS.length() - 1; i++) {
                if (!Character.isDigit(addressS.charAt(i)) && !Character.isLetter(addressS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "address", addressS);
        }
        if(!phoneNumS.equals("")) {
            for (int i = 0; i <= phoneNumS.length() - 1; i++) {
                if (!Character.isDigit(phoneNumS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "phoneNum", phoneNumS);
        }
        if(!nameOfClinicS.equals("")) {
            for (int i = 0; i <= nameOfClinicS.length() - 1; i++) {
                if (!Character.isDigit(nameOfClinicS.charAt(i)) && !Character.isLetter(nameOfClinicS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "nameOfClinic", nameOfClinicS);
        }
        if(!insuranceS.equals("")) {
            for (int i = 0; i <= insuranceS.length() - 1; i++) {
                if (!Character.isDigit(insuranceS.charAt(i)) && !Character.isLetter(insuranceS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "insuranceTypes", insuranceS);
        }
        if(!paymentS.equals("")) {
            for (int i = 0; i <= paymentS.length() - 1; i++) {
                if (!Character.isDigit(paymentS.charAt(i)) && !Character.isLetter(paymentS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    name.setText("");
                    address.setText("");
                    phoneNum.setText("");
                    insuranceType.setText("");
                    nameOfClinic.setText("");
                    paymentMethod.setText("");
                    b.show();
                    return;
                }
            }
            dataBase.update("Employee", "userName", userName, "paymentMethod", paymentS);
        }
        dataBase.close();
        Toast.makeText(editEmployeeProfiles.this, "Success!!! Please login again.", Toast.LENGTH_LONG).show();
        finish();
    }
}
