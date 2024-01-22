package com.grpc.hrm.utils;

public class TaxCalculationOfStaff {
    public static double calculateTaxForUnmarried(double totalSalary, double totalDeduction) {
        double netAssessable = totalDeduction > 0
                ? totalSalary - totalDeduction
                : totalSalary;

        double[] taxRates = totalDeduction > 0
                ? new double[]{0.0, 0.1, 0.2, 0.3}
                : new double[]{0.01, 0.1, 0.2, 0.3};

        double[] taxSlabs = {500000, 200000, 300000, 1000000};


        double tax = 0.0;
        double remainingIncome = netAssessable;

        if (netAssessable <= 2000000) {
            for (int i = 0; i < taxSlabs.length; i++) {
                if (remainingIncome <= taxSlabs[i]) {
                    tax += remainingIncome * taxRates[i];
                    break;
                } else {
                    tax += taxSlabs[i] * taxRates[i];
                    remainingIncome -= taxSlabs[i];
                }
            }
        } else {
            for (int i = 0; i < taxSlabs.length; i++) {
                tax += taxSlabs[i] * taxRates[i];
                remainingIncome -= taxSlabs[i];
            }
            tax += remainingIncome * 0.36;
        }

        return tax;
    }


    public static double calculateTaxForMarried(double totalSalary, double totalDeduction) {

        double netAssessable = totalDeduction > 0
                ? totalSalary - totalDeduction
                : totalSalary;

        double[] taxRates = totalDeduction > 0
                ? new double[]{0.0, 0.1, 0.2, 0.3}
                : new double[]{0.01, 0.1, 0.2, 0.3};

        double[] taxSlabs = {600000, 200000, 300000, 1000000};


        double tax = 0.0;
        double remainingIncome = netAssessable;

        if (netAssessable <= 2100000) {
            for (int i = 0; i < taxSlabs.length; i++) {
                if (remainingIncome <= taxSlabs[i]) {
                    tax += remainingIncome * taxRates[i];
                    break;
                } else {
                    tax += taxSlabs[i] * taxRates[i];
                    remainingIncome -= taxSlabs[i];
                }
            }
        } else {
            for (int i = 0; i < taxSlabs.length; i++) {
                tax += taxSlabs[i] * taxRates[i];
                remainingIncome -= taxSlabs[i];
            }
            tax += remainingIncome * 0.36;
        }

        return tax;
    }

}
