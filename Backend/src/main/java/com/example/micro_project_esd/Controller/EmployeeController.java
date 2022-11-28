package com.example.micro_project_esd.Controller;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.DAO.DAOImplementation.EmployeeDAOimpl;
import com.example.micro_project_esd.DAO.EmployeeDAO;
import com.example.micro_project_esd.Service.EmployeeService;
import com.example.micro_project_esd.Service.Employee_SalaryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("employee")
public class EmployeeController
{
    EmployeeDAO employeeDAO =new EmployeeDAOimpl();
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_employee(Employee employee)
    {
        if(employeeDAO.AddEmployee(employee))
        {
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding employee").build();
    }

    EmployeeService employeeService=new EmployeeService();
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response check_login_credentials(Employee employee) {
        Employee LoginEmployee = employeeService.login_with_employee(employee);
        if (LoginEmployee == null) {
            return Response.status(400).entity("Invalid Credentials").build();
        } else {
            return Response.ok().entity(LoginEmployee).build();
        }
    }

    @POST
    @Path("/Modify_salary_details")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify_salary_details(Employee employee)
    {
        boolean modify_employee_details=employeeService.modify_details(employee);
        if(modify_employee_details)
        {
            return Response.ok().entity("successfully modify details").build();
        }
        else
        {
            return Response.status(400).entity("Invalid Credentials").build();
        }
    }
    @POST
    @Path("/ModifyStatus")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify_employee_status(Employee employee)
    {
        boolean ModifyStatus=employeeService.modify_status(employee);
        if(ModifyStatus)
        {
            return Response.ok().entity("successfully modified status").build();
        }
        else
        {
            return Response.status(400).entity("Invalid Credentials").build();
        }
    }

    @GET
    @Path("employee_details")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get_employee_details()
    {
        List<Employee> employeeList =employeeService.employee_details();
        if(employeeList==null)
        {
            return Response.status(400).entity("Failure while fetching employee details").build();
        }
        return Response.ok().entity(employeeList).build();
    }


    @GET
    @Path("single_employee_details")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response get_one_employee_details(@QueryParam("employee_id") int employee_id)
    {
        List<Employee> employeeList =employeeService.one_employee_details(employee_id);
        if(employeeList==null)
        {
            return Response.status(400).entity("Failure while fetching employee details").build();
        }
        return Response.ok().entity(employeeList).build();
    }


}
