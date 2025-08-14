package com.example.simulating_a_multinational_pharmaceutical_company;

import java.io.Serializable;

public class CustomerSupportDashboardClass implements Serializable {

    private  String name;
    private String date;
    private String priority ;

    public CustomerSupportDashboardClass(String name, String date, String priority) {
        this.name = name;
        this.date = date;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CustomerSupportDashboardClass{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
