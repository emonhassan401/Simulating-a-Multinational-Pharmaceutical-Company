package com.example.simulating_a_multinational_pharmaceutical_company;

import java.io.Serializable;

public class financialDashboardClass implements Serializable {



    private String revenue;
    private String expense;
    private String profit;

    public financialDashboardClass(String expense, String revenue, String profit) {
        this.expense = expense;
        this.revenue = revenue;
        this.profit = profit;
    }


    public String getProfit() { return profit; }
    public void setProfit(String profit) { this.profit = profit; }
    public String getExpense() { return expense; }
    public void setExpense(String expense) { this.expense = expense; }
    public String getRevenue() { return revenue; }
    public void setRevenue(String revenue) { this.revenue = revenue; }


    @Override
    public String toString() {
        return "Revenue: " + revenue + ", Expense: " + expense + ", Profit: " + profit;
    }
}
