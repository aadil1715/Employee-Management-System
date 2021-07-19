package com.dalhousie.group14.BusinessLogic.utilities;
//S of S.O.L.I.D is used and developed by TDD
import com.dalhousie.group14.BusinessLogic.employee.Employee;
import com.dalhousie.group14.BusinessLogic.manager.Manager;
import com.dalhousie.group14.Database.employee.EmployeeDBOperation;


import java.util.HashMap;
import java.util.Map;

public class Salaries {
    private String manager;
    private Map<String,String> info;
//    Salaries(Manager manager,Employee employee){
//        this.manager=manager.getUserName();
//        info=new HashMap<String,String>();
//    }
    public Map viewSalary(Employee employee){

        String emp=employee.getUserName();
        EmployeeDBOperation d=new EmployeeDBOperation();
        Map<String,Double> salary_info=new HashMap<>();
        Map<String,String> info=new HashMap<>();
        info= d.getEmployeeInfo(emp);
        String ctc_string=info.get("ctc");
        double ctc=Double.parseDouble(ctc_string);
        salary_info.put("CTC",ctc);
        String epf_string=info.get("epf");
        double epf=Double.parseDouble(epf_string);
        salary_info.put("EPF",epf);
        String bs_string=info.get("basic_salary");
        double basic_salary=Double.parseDouble(bs_string);
        salary_info.put("basic_salary",basic_salary);
        double gross_salary;
        double gratuity=basic_salary*15/26;
        salary_info.put("Gratuity",gratuity);
        Taxes t=new TaxesIn2021();
        double tax=t.computeTaxes(ctc,epf,basic_salary);
        salary_info.put("tax",tax);
        gross_salary=ctc-epf-gratuity;
        salary_info.put("gross_salary",gross_salary);
        String bonus_string=info.get("bonus");
        double bonus=Double.parseDouble(bonus_string);
        salary_info.put("bonus",bonus);
        double take_home_salary=gross_salary-tax-epf+bonus;
        salary_info.put("tax_home_salary",take_home_salary);
        return  salary_info;

    }
    public boolean updateSalary(String employee,double amount,String salryType){
        EmployeeDBOperation d=new EmployeeDBOperation();

        return ((EmployeeDBOperation) d).setEmployee(employee,salryType,amount);

    }


}
