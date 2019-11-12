package com.example.seg_androidproject.Clinics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Clinic {
    private static List<String> s1 = new ArrayList<>(Arrays.asList("Injection"," by nurse"));
    private static List<String> s2 = new ArrayList<>(Arrays.asList("Sell medicine"," by staff"));
    private static List<String> s3 = new ArrayList<>(Arrays.asList("Infusion"," by nurse"));
    private static List<String> s4 = new ArrayList<>(Arrays.asList("Tooth extraction"," by doctor"));
    private static List<String> s5 = new ArrayList<>(Arrays.asList("Optometry"," by staff"));
    private  ArrayList<List> services = new ArrayList<List>(Arrays.asList(s1, s2, s3, s4, s5));

    public Clinic(){ }

    public ArrayList<List> getServices(){
        return services;
    }

    public boolean addService(String service, String r){
        if(service.equals("")){
            return false;
        }
        List<String> new_service = new ArrayList<>(Arrays.asList(service, r));
        if (services.contains(new_service)){
            return false;
        }
        else{
            services.add(new_service);
            return true;
        }
    }

    public boolean deleteService(String service, String r){
        if(service.equals("")){
            return false;
        }
        List<String> new_service = new ArrayList<>(Arrays.asList(service, r));
        if(services.contains(new_service)){
            services.remove(new_service);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean editService(String service, String new_service, String r){
        return this.deleteService(service, r) && this.addService(new_service, r);
    }
}
