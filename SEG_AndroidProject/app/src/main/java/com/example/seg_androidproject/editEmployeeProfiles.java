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
    private Employee employee;
    private Employee employee_old;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_employee_profiles);
        DataBase dataBase = new DataBase(this);
        Intent intent = getIntent();
        userName = intent.getStringExtra("userName");
        //employee.setUserName(userName);
        employee_old = dataBase.getEmployee(userName);
    }

    public void doneEditOnClick(View view){
        System.out.print(userName);
        DataBase dataBase = new DataBase(this);
/*
        String passwordS = "";
        String nameS = "";
        String addressS = "";
        String phoneNumS = "";
        int phoneNumI = 0;
        String nameOfClinicS = "";
        String insuranceS = "";
        String paymentS = "";
*/
        EditText password = (EditText) findViewById(R.id.passwordEText);
        EditText name = (EditText) findViewById(R.id.nameEText);
        EditText address = (EditText) findViewById(R.id.addressEText);
        EditText phoneNum = (EditText) findViewById(R.id.phoneNumEText);
        EditText nameOfClinic = (EditText) findViewById(R.id.nameOfClinicEText);
        EditText insuranceType = (EditText) findViewById(R.id.insuranceEText);
        EditText paymentMethod = (EditText) findViewById(R.id.paymentEText);

        String passwordS = password.getText().toString();

        //if(name != null){
            String nameS = name.getText().toString();
        //}
        //if(address != null){
            String addressS = address.getText().toString();
        //}
        //if(phoneNum != null){
            String phoneNumS = phoneNum.getText().toString();
            int phoneNumI = Integer.parseInt(phoneNumS);
        //}
        //if(nameOfClinic != null){
            String nameOfClinicS = nameOfClinic.getText().toString();
        //}
        //if(insuranceType != null){
            String insuranceS = insuranceType.getText().toString();
        //}
        //if(paymentMethod != null){
            String paymentS = paymentMethod.getText().toString();
        //}

        if(passwordS.length() > 50 || nameS.length() > 50 || addressS.length() > 50 || phoneNumS.length() > 10 || nameOfClinicS.length() > 50 || insuranceS.length() > 50 || paymentS.length() > 50){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Invalid Input");
            builder.setMessage("The information you entered are too long, please try again.");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface arg0, int arg1){}
            });
            AlertDialog b = builder.create();
            password.setText("");
            name.setText("");
            address.setText("");
            phoneNum.setText("");
            insuranceType.setText("");
            nameOfClinic.setText("");
            paymentMethod.setText("");
            b.show();
            return;
        }

        if(!passwordS.equals("")) {
            for (int i = 0; i <= passwordS.length() - 1; i++) {
                if (!Character.isDigit(passwordS.charAt(i)) && !Character.isLetter(passwordS.charAt(i))) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Invalid Input");
                    builder.setMessage("The information you entered are invalid, please try again.");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface arg0, int arg1) {
                        }
                    });
                    AlertDialog b = builder.create();
                    password.setText("");
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
            employee.setPassword(passwordS);
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
                    password.setText("");
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
            employee.setName(nameS);
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
                    password.setText("");
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
            employee.setAddress(addressS);
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
                    password.setText("");
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
            employee.setPhoneNum(phoneNumI);
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
                    password.setText("");
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
            employee.setNameOfClinic(nameOfClinicS);
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
                    password.setText("");
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
            employee.setInsuranceTypes(insuranceS);
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
                    password.setText("");
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
            employee.setPaymentMethod(paymentS);
        }
        dataBase.remove("Employee", userName);
        dataBase.insertEmployee(employee);
        Toast.makeText(editEmployeeProfiles.this, "Success!!!", Toast.LENGTH_LONG).show();
        finish();
    }
}
