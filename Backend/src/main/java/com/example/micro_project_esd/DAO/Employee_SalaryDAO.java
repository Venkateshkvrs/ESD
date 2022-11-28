package com.example.micro_project_esd.DAO;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.Bean.Employee_Salary;

import java.util.List;

public interface Employee_SalaryDAO
{
    boolean AddSalary(Employee_Salary SalObj);
    boolean DisburseSalary(List<Employee_Salary> SalInfo);

    boolean DisburseSalaryById(List<Employee> SalInfo);
}
