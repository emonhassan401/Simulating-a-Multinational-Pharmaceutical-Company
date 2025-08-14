package com.example.simulating_a_multinational_pharmaceutical_company;

public class NewCustomerQueryClass {
    private String name ;
    private String inquery ;
    private String customerType;
    private String email ;
    private String phone ;

    public NewCustomerQueryClass(String name, String phone, String email, String customerType, String inquery) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.customerType = customerType;
        this.inquery = inquery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInquery() {
        return inquery;
    }

    public void setInquery(String inquery) {
        this.inquery = inquery;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "NewCustomerQueryClass{" +
                "name='" + name + '\'' +
                ", inquery='" + inquery + '\'' +
                ", customerType='" + customerType + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
