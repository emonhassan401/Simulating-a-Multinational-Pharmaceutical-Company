package com.example.simulating_a_multinational_pharmaceutical_company;

import java.io.Serializable;

public class ActualSalesVsProjectedBudgeClass  implements Serializable {

    private String querter ;
    private String budget ;
    private String sale ;

    public ActualSalesVsProjectedBudgeClass(String querter, String budget, String sale) {
        this.querter = querter;
        this.budget = budget;
        this.sale = sale;
    }

    public String getQuerter() {
        return querter;
    }

    public void setQuerter(String querter) {
        this.querter = querter;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "ActualSalesVsProjectedBudgeClass{" +
                "querter='" + querter + '\'' +
                ", budget='" + budget + '\'' +
                ", sale='" + sale + '\'' +
                '}';
    }
}
