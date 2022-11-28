package com.example.micro_project_esd.Service;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.DAO.DAOImplementation.EmployeeDAOimpl;
import com.example.micro_project_esd.DAO.EmployeeDAO;

import java.util.List;

public class EmployeeService {
    EmployeeDAO employeeDAO = new EmployeeDAOimpl();

    public Employee login_with_employee(Employee employee) {
        Employee LoginEmployee = employeeDAO.login_with_employee(employee);

        // If no login happens, then return null
        if (LoginEmployee == null)
            return null;

        return LoginEmployee;
    }

    public boolean modify_details(Employee employee)
    {
        boolean modify_detail=employeeDAO.modify_salary(employee);
        if(modify_detail)
        {
            return true;
        }
        return false;
    }
    public boolean modify_status(Employee employee)
    {
        boolean modify_detail=employeeDAO.modify_status(employee);
        if(modify_detail)
        {
            return true;
        }
        return false;
    }

    public List<Employee> employee_details()
    {
        return employeeDAO.Employee_Details();
    }

    public List<Employee> one_employee_details(int employee_id)
    {
        return employeeDAO.one_Employee_Details(employee_id);
    }




}
