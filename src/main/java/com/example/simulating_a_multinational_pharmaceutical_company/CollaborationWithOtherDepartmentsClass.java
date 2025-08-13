package com.example.simulating_a_multinational_pharmaceutical_company;

public class CollaborationWithOtherDepartmentsClass {

    private String name;
    private String dept ;
    private  String query ;

    public CollaborationWithOtherDepartmentsClass(String name, String query, String dept) {
        this.name = name;
        this.query = query;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "CollaborationWithOtherDepartmentsClass{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}

