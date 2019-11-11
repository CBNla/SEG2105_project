package com.example.seg_androidproject;

import com.example.seg_androidproject.Clinics.Clinic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ServiceTest {
    @Test
    public void getServiceTest(){
        List<String> s1 = new ArrayList<>(Arrays.asList("Injection"," by nurse"));
        List<String> s2 = new ArrayList<>(Arrays.asList("Sell medicine"," by staff"));
        List<String> s3 = new ArrayList<>(Arrays.asList("Infusion"," by nurse"));
        List<String> s4 = new ArrayList<>(Arrays.asList("Tooth extraction"," by doctor"));
        List<String> s5 = new ArrayList<>(Arrays.asList("Optometry"," by staff"));
        ArrayList<List> services = new ArrayList<List>(Arrays.asList(s1, s2, s3, s4, s5));
        Clinic clinic = new Clinic();
        assertEquals("Check all the services", services, clinic.getServices());
    }

    @Test
    public void addTest(){
        Clinic clinic = new Clinic();
        assertEquals("Check if we can add new service", true, clinic.addService("hh", " by nurse"));
    }

    @Test
    public void editTest(){
        Clinic clinic = new Clinic();
        clinic.addService("hh", " by nurse");
        assertEquals("Check if we can edit the exist service", true, clinic.editService("hh", "h", " by nurse"));
    }

    @Test
    public void deleteTest(){
        Clinic clinic = new Clinic();
        clinic.addService("h", " by nurse");
        assertEquals("Check if we can delete the exist service", true, clinic.deleteService("h", " by nurse"));
    }
}
