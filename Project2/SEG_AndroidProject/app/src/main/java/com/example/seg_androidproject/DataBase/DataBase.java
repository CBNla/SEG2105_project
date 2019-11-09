package com.example.seg_androidproject.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.seg_androidproject.Clinics.Admin;
import com.example.seg_androidproject.Clinics.Clients;
import com.example.seg_androidproject.Clinics.Employee;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataBase extends SQLiteOpenHelper {
    private static final String NAMEofDataBase = "ClinicDataBase.db";
    private static final int VERSION = 1;

    public DataBase(Context context){
        super(context, NAMEofDataBase, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createClientTable = "create table Client(" + "userName varchar(50)," + "password varchar(50)," + "name varchar(50)," + "age int," + "primary key(userName))";
        db.execSQL(createClientTable);
        String createEmployeeTable = "create table Employee(" + "userName varchar(50)," + "password varchar(50)," + "name varchar(50)," + "primary key(UserName))";
        db.execSQL(createEmployeeTable);
        String createAdminTable = "create table Admin(" + "userName varchar(50)," + "password varchar(50)," + "name varchar(50)," + "primary key(userName))";
        db.execSQL(createAdminTable);
        String new_password = encrypt("5T5ptQ");
        ContentValues values = new ContentValues();
        values.put("userName", "admin");
        values.put("password", new_password);
        values.put("name", "admin");
        db.insert("Admin", null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlC = "delete table if exists Client";
        String sqlE = "delete table if exists Employee";
        String sqlA = "delete table if exists Admin";
        onCreate(db);
    }

    public void insertClient(Clients client){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("userName", client.getUserName());
        String encrypted = encrypt(client.getPassword());
        values.put("password", encrypted);
        values.put("name", client.getName());
        values.put("age", client.getAge());
        database.insert("Client", null, values);
        database.close();
    }

    public void remove(String table, String uName){
        SQLiteDatabase database = getWritableDatabase();
        String removeElement = "DELETE FROM " + table + " WHERE userName = \"" + uName + "\"";
        database.execSQL(removeElement);
        database.close();
    }

    public String[] showC(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select userName, name, age from Client", null);
        String[] result = new String[cursor.getCount()];
        cursor.moveToFirst();
        if(cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String s = "userName: " + cursor.getString(0) + " name: " + cursor.getString(1) + " age: " + cursor.getString(2);
                result[i] = s;
                cursor.moveToNext();
            }
        }
        else{
            result = null;
        }
        cursor.close();
        database.close();
        return result;
    }

    public String[] showE(){
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("select userName, name from Employee", null);
        String[] result = new String[cursor.getCount()];
        cursor.moveToFirst();
        if(cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                String s = "userName: " + cursor.getString(0) + " name: " + cursor.getString(1);
                result[i] = s;
                cursor.moveToNext();
            }
        }
        else{
            result = null;
        }
        cursor.close();
        database.close();
        return result;
    }

    public void insertEmployee(Employee employee){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        String encrypted = encrypt(employee.getPassword());
        values.put("userName", employee.getUserName());
        values.put("password", encrypted);
        values.put("name", employee.getName());
        database.insert("Employee", null, values);
        database.close();
    }

    public Clients clientExist(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();
        String new_password = encrypt(password);
        String sql = "select userName, password, name, age from Client where userName = \"" + userName +"\"" + "and password = \"" + new_password + "\"";
        Cursor cursor = db.rawQuery(sql, null);
        Clients client = new Clients();
        if (cursor.moveToFirst()) {
            client.setUserName(cursor.getString(0));
            client.setPassword(cursor.getString(1));
            client.setName(cursor.getString(2));
            client.setAge(cursor.getInt(3)) ;
        }
        else {
            client = null;
        }
        cursor.close();
        db.close();
        return client;
    }

    public boolean cExist(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select userName, password, name, age from Client where userName = \"" + userName +"\"";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public Employee employeeExist(String userName, String password){
        SQLiteDatabase db = getReadableDatabase();
        String new_password = encrypt(password);
        String sql = "select userName, password, name from Employee where userName=\"" + userName +"\"" + "and password = \"" + new_password + "\"";
        Cursor cursor = db.rawQuery(sql, null);
        Employee employee = new Employee();
        if (cursor.moveToFirst()) {
            employee.setUserName(cursor.getString(0));
            employee.setPassword(cursor.getString(1));
            employee.setName(cursor.getString(2));
        }
        else {
            employee = null;
        }
        cursor.close();
        db.close();
        return employee;
    }

    public boolean eExist(String userName){
        SQLiteDatabase db = getReadableDatabase();
        String sql = "select userName, password, name from Employee where userName = \"" + userName +"\"";
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }

    public Admin adminExist(String userName, String password){
        String p = encrypt("5T5ptQ");
        Admin admin = new Admin();
        String new_password = encrypt(password);
        if (userName.equals(admin.getUserName()) && new_password.equals(p)){
            return admin;
        }
        else{
            return null;
        }
    }

    private String convertToHexString(byte data[]) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < data.length; i++) {
            stringBuffer.append(Integer.toHexString(0xff & data[i]));
        }
        return stringBuffer.toString();
    }

    private String encrypt(String password) {
        byte data[] = null;
        MessageDigest m;
        try {
            data = password.getBytes("UTF8");
            m = MessageDigest.getInstance("SHA-256");
            m.update(data);
            byte resultData[] = m.digest();
            return convertToHexString(resultData);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}