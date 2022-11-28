package com.example.micro_project_esd.DAO;

import com.example.micro_project_esd.Bean.Department;
import com.example.micro_project_esd.Bean.Employee;

import java.util.List;

public interface EmployeeDAO
{
    boolean AddEmployee(Employee EmpObj);
    Employee login_with_employee(Employee employee);
    Boolean modify_salary(Employee employee);

    Boolean modify_status(Employee employee);
    List<Employee> Employee_Details();

    List<Employee> one_Employee_Details(int employee_id);
}
