package com.example.simulating_a_multinational_pharmaceutical_company;

import java.time.LocalDate;

public class SalesReportClass {
     private  String productName ;
     private  String unitSold ;
     private String totalSale ;
     private String salesRegion ;
     private String productCatagory ;
     private LocalDate date ;

    public SalesReportClass(String productName, LocalDate date, String salesRegion, String totalSale, String unitSold, String productCatagory) {
        this.productName = productName;
        this.date = date;
        this.salesRegion = salesRegion;
        this.totalSale = totalSale;
        this.unitSold = unitSold;
        this.productCatagory = productCatagory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProductCatagory() {
        return productCatagory;
    }

    public void setProductCatagory(String productCatagory) {
        this.productCatagory = productCatagory;
    }

    public String getSalesRegion() {
        return salesRegion;
    }

    public void setSalesRegion(String salesRegion) {
        this.salesRegion = salesRegion;
    }

    public String getUnitSold() {
        return unitSold;
    }

    public void setUnitSold(String unitSold) {
        this.unitSold = unitSold;
    }

    public String getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(String totalSale) {
        this.totalSale = totalSale;
    }

    @Override
    public String toString() {
        return "SalesReportClass{" +
                "productName='" + productName + '\'' +
                ", unitSold='" + unitSold + '\'' +
                ", totalSale='" + totalSale + '\'' +
                ", salesRegion='" + salesRegion + '\'' +
                ", productCatagory='" + productCatagory + '\'' +
                ", date=" + date +
                '}';
    }
}

