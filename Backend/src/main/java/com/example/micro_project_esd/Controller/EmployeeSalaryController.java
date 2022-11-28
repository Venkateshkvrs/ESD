package com.example.micro_project_esd.Controller;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.Bean.Employee_Salary;
import com.example.micro_project_esd.DAO.DAOImplementation.Employee_salaryDAOimpl;
import com.example.micro_project_esd.DAO.Employee_SalaryDAO;
import com.example.micro_project_esd.Service.Employee_SalaryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employee_salary")
public class EmployeeSalaryController
{
    Employee_SalaryDAO employee_salaryDAO =new Employee_salaryDAOimpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)

    public Response add_employee_salary(Employee_Salary employee_salary)
    {
        if(employee_salaryDAO.AddSalary(employee_salary))
        {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding employee Salary").build();
    }

    Employee_SalaryService employee_salaryService=new Employee_SalaryService();
    @POST
    @Path("disburse_salary")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response disburse_salary_employee(List<Employee_Salary>SalInfo)
    {
        if(employee_salaryService.disburse_salary(SalInfo))
        {
            return Response.status(200).entity("Successfully disburse salary").build();
        }
        return Response.status(400).entity("Failure while disburse employee/employees Salary").build();
    }

    @POST
    @Path("disburse_salaryById")
    @Consumes(MediaType.APPLICATION_JSON)
    public  Response disburse_salary_By_Id_employee(List<Employee>SalInfo)
    {
        if(employee_salaryService.DisburseSalaryByIdService(SalInfo))
        {
            return Response.status(200).entity("Successfully disbursed salary").build();
        }
        return Response.status(400).entity("Failure while disburse employee/employees Salary").build();
    }
}
