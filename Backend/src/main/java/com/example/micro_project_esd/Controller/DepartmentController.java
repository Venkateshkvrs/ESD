package com.example.micro_project_esd.Controller;

import com.example.micro_project_esd.Bean.Department;
import com.example.micro_project_esd.DAO.DAOImplementation.DepartmentDAOimpl;
import com.example.micro_project_esd.DAO.DepartmentDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hibernate.annotations.Polymorphism;

@Path("department")
public class DepartmentController 
{
    DepartmentDAO DeptDAO=new DepartmentDAOimpl();
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)

    public Response add_department(Department dept){
        System.out.printf(String.valueOf(dept));
        if(DeptDAO.addDepartment(dept)){
            return Response.status(200).entity("Success").build();
        }

        return Response.status(400).entity("Failure while adding department").build();
    }


}
