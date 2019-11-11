package com.example.seg_androidproject;

import com.example.seg_androidproject.Clinics.Employee;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTest {
    @Test
    public void employeeUserNameTest(){
        Employee employee = new Employee("George", "123", "George");
        assertEquals("Check the user name of the employee account", "George", employee.getUserName());
    }

    @Test
    public void changeUserNameTest(){
        Employee employee = new Employee("George", "123", "George");
        employee.setUserName("Wang");
        assertEquals("Check the user name of the employee account", "Wang", employee.getUserName());
    }

    @Test
    public void employeeNameTest(){
        Employee employee = new Employee("George", "123", "George");
        assertEquals("Check the name of the employee account", "George", employee.getName());
    }

    @Test
    public void changeNameTest(){
        Employee employee = new Employee("George", "123", "George");
        employee.setName("Wang");
        assertEquals("Check the user name of the employee account", "Wang", employee.getName());
    }

    @Test
    public void employeePasswordTest(){
        Employee employee = new Employee("George", "123", "George");
        assertEquals("Check the password of the employee account", "123", employee.getPassword());
    }

    @Test
    public void changePasswordTest(){
        Employee employee = new Employee("George", "123", "George");
        employee.setPassword("456");
        assertEquals("Check the user name of the employee account", "456", employee.getPassword());
    }
}
