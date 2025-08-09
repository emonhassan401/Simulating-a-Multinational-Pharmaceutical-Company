
package com.example.simulating_a_multinational_pharmaceutical_company;
public class mainlogin {

    private  String name ;
    private  String pass ;
    private  String role;


    public mainlogin(String role, String pass, String name) {
        this.role = role;
        this.pass = pass;
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Mainlogin{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}


