package com.example.seg_androidproject.Clinics;

public class Clinic {
    private String[] services = new String[5];
    private int length = 5;

    public Clinic(){
        services[1] = "Injection";
        services[2] = "Sell medicine";
        services[3] = "Infusion";
        services[4] = "Tooth extraction";
        services[5] = "Optometry";
    }

    public Clinic(String[] services){
        this.services = services;
    }

    public String[] getServices(){
        return services;
    }

    public void addService(String service){
        boolean in = false;
        for (int i = 0; i < length; i++){
            if(services[i] == null){
                services[i] = service;
                in = true;
                break;
            }
        }
        if(!in){
            String[] n_services = new String[2*length];
            for(int i = 0; i < length; i++){
                n_services[i] = services[i];
            }
            n_services[length] = service;
            length += 1;
            services = n_services;
        }
    }
}
