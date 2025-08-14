package com.example.simulating_a_multinational_pharmaceutical_company;

public class CustomerFeedbackReportsClass {

    private String name ;
    private String id ;
    private  String describeIssue;
    private  String status ;

    public CustomerFeedbackReportsClass(String status, String id, String describeIssue, String name) {
        this.status = status;
        this.id = id;
        this.describeIssue = describeIssue;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescribeIssue() {
        return describeIssue;
    }

    public void setDescribeIssue(String describeIssue) {
        this.describeIssue = describeIssue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "CustomerFeedbackReportsClass{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", describeIssue='" + describeIssue + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
