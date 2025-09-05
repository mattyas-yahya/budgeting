package com.budgeting.model;


public class VarianceReport {
    private String coaCode;
    private String coaName;
    private String costCenterCode;
    private String costCenterName;
    private double budget;
    private double actual;
    private double variance;
    private double variancePercentage;

    // Getters and Setters
    public String getCoaCode() { return coaCode; }
    public void setCoaCode(String coaCode) { this.coaCode = coaCode; }

    public String getCoaName() { return coaName; }
    public void setCoaName(String coaName) { this.coaName = coaName; }

    public String getCostCenterCode() { return costCenterCode; }
    public void setCostCenterCode(String costCenterCode) { this.costCenterCode = costCenterCode; }

    public String getCostCenterName() { return costCenterName; }
    public void setCostCenterName(String costCenterName) { this.costCenterName = costCenterName; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public double getActual() { return actual; }
    public void setActual(double actual) { this.actual = actual; }

    public double getVariance() { return variance; }
    public void setVariance(double variance) { this.variance = variance; }

    public double getVariancePercentage() { return variancePercentage; }
    public void setVariancePercentage(double variancePercentage) { this.variancePercentage = variancePercentage; }
}