package com.example.seg_androidproject;

import com.example.seg_androidproject.Clinics.Clinic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExceptionsTest {
    @Test
    public void addTest(){
        Clinic clinic = new Clinic();
        assertEquals("Check if we can add new service", false, clinic.addService("", " by nurse"));
    }

    @Test
    public void editTest1(){
        Clinic clinic = new Clinic();
        clinic.addService("hh", " by nurse");
        assertEquals("Check if we can edit the exist service", false, clinic.editService("", "h", " by nurse"));
    }

    @Test
    public void editTest2(){
        Clinic clinic = new Clinic();
        clinic.addService("hh", " by nurse");
        assertEquals("Check if we can edit the exist service", false, clinic.editService("hh", "", " by nurse"));
    }

    @Test
    public void deleteTest(){
        Clinic clinic = new Clinic();
        clinic.addService("h", " by nurse");
        assertEquals("Check if we can delete the exist service", false, clinic.deleteService("", " by nurse"));
    }
}
