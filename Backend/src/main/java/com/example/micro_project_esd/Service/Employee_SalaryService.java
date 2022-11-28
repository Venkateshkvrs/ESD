package com.example.micro_project_esd.Service;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.Bean.Employee_Salary;
import com.example.micro_project_esd.DAO.DAOImplementation.Employee_salaryDAOimpl;
import com.example.micro_project_esd.DAO.Employee_SalaryDAO;

import java.util.List;

public class Employee_SalaryService
{
        Employee_SalaryDAO employee_salaryDAO=new Employee_salaryDAOimpl();
        public boolean disburse_salary(List<Employee_Salary>SalObj)
        {
            boolean result= employee_salaryDAO.DisburseSalary(SalObj);
            if(result)
            {
                return true;
            }
            return false;

        }
        public boolean DisburseSalaryByIdService(List<Employee> SalInfo){
            boolean result= employee_salaryDAO.DisburseSalaryById(SalInfo);
            if(result)
            {
                return true;
            }
            return false;
        }

}
