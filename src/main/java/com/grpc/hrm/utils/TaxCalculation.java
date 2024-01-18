package com.grpc.hrm.utils;

import com.grpc.hrm.model.Staff;

public class TaxCalculation {


    public static double taxCalculationPerYearForUnmarried(Staff staff) {
        double totalSalary = staff.getSalary() * 12;
        double tax = 0.0;

        double socialSecurityFund=0.0;
        double employeeProvidentFund=0.0;
        double citizenInvestmentTrust=0.0;
        double insurance=0.0;
        double totalDeduction=0.0;



        if (totalSalary <= 500000) {
            tax = totalSalary * 0.01;
        } else if (totalSalary <= 700000) {
            // 5,00,000 * 0.01 + (totalSalary - 5,00,000) * 0.1
            tax = 5000 + (totalSalary - 500000) * 0.1;
        } else if (totalSalary <= 1000000) {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + (totalSalary - 7,00,000) * 0.2
            tax = 5000 + 20000 + (totalSalary - 700000) * 0.2;
        } else if (totalSalary <= 2000000) {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + (totalSalary - 10,00,000) * 0.3
            tax = 5000 + 20000 + 60000 + (totalSalary - 1000000) * 0.3;
        } else {
            // 5,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + 10,00,000 * 0.3 + (totalSalary - 20,00,000) * 0.36
            tax = 5000 + 20000 + 60000 + 300000 + (totalSalary - 2000000) * 0.36;
        }
        return tax;
    }


    public static double taxCalculationPerYearForMarried(Staff staff) {
        double totalSalary = staff.getSalary() * 12;
        double tax = 0.0;

        if (totalSalary <= 600000) {
            tax = totalSalary * 0.01;
        } else if (totalSalary <= 800000) {
            // 6,00,000 * 0.01 + (totalSalary - 6,00,000) * 0.1
            tax = 6000 + (totalSalary - 600000) * 0.1;
        } else if (totalSalary <= 1100000) {
            // 6,00,000 * 0.01 + 2,00,000 * 0.1 + (totalSalary - 8,00,000) * 0.2
            tax = 6000 + 20000 + (totalSalary - 800000) * 0.2;
        } else if (totalSalary <= 2000000) {
            // 6,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + (totalSalary - 11,00,000) * 0.3
            tax = 6000 + 20000 + 60000 + (totalSalary - 1100000) * 0.3;
        } else {
            // 6,00,000 * 0.01 + 2,00,000 * 0.1 + 3,00,000 * 0.2 + 10,00,000 * 0.3 + (totalSalary - 20,00,000) * 0.36
            tax = 6000 + 20000 + 60000 + 300000 + (totalSalary - 2000000) * 0.36;
        }
        return tax;
    }
}
