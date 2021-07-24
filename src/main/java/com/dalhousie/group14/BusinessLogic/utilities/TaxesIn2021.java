package com.dalhousie.group14.BusinessLogic.utilities;

//This isi the taxes only for year 2021 if we need to use some different rules we can make a seperate class
public class TaxesIn2021 implements Taxes {

  @Override
  public double computeTaxes(double ctc, double epf, double basic_salary) {
    double gratuity = basic_salary * 15 / 26;
    double gross_salary = ctc - epf - gratuity;
    double taxable_income = 0.5 * gross_salary;
    double tax = 0;
    if (taxable_income < 250000) {
      tax = 0.0;
    } else if (taxable_income < 500000 && taxable_income > 250000) {
      tax = 0.2 * taxable_income;
    } else if (taxable_income > 500000) {
      tax = 12500 + 0.2 * (taxable_income - 500000);
    }
    return tax;
  }
}
