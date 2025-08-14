package com.example.simulating_a_multinational_pharmaceutical_company;

import java.io.Serializable;

public class TicketStatusDashboardClass  {
    private String name;
    private String id ;
    private String status ;
    private String issue ;

    public TicketStatusDashboardClass(String name, String id, String status, String issue) {
        this.name = name;
        this.id = id;
        this.status = status;
        this.issue = issue;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TicketStatusDashboardClass{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", issue='" + issue + '\'' +
                '}';
    }
}
