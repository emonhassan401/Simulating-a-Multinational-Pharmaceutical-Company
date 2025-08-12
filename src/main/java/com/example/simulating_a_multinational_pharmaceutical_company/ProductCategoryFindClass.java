package com.example.simulating_a_multinational_pharmaceutical_company;

import java.time.LocalDate;

public class ProductCategoryFindClass {

    private String productCatagory;
    private LocalDate date;

    // Constructor: date first, category second
    public ProductCategoryFindClass(LocalDate date, String productCatagory) {
        this.date = date;
        this.productCatagory = productCatagory;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ProductCategoryFindClass{" +
                "productCatagory='" + productCatagory + '\'' +
                ", date=" + date +
                '}';
    }
}
