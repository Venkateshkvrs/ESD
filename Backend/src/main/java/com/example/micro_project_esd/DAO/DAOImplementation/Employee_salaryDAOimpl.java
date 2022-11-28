package com.example.micro_project_esd.DAO.DAOImplementation;

import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.Bean.Employee_Salary;
import com.example.micro_project_esd.DAO.EmployeeDAO;
import com.example.micro_project_esd.DAO.Employee_SalaryDAO;
import com.example.micro_project_esd.util.HibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.crypto.SealedObject;
import java.awt.*;
import java.sql.Date;
import java.util.List;
import java.time.LocalDate;
public class Employee_salaryDAOimpl implements Employee_SalaryDAO
{

    @Override
    public boolean AddSalary(Employee_Salary SalObj)
    {
        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction transaction= session.beginTransaction();
            session.save(SalObj);
            transaction.commit();
            return true;
        }
        catch (HeadlessException exception)
        {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return true;
        }
    }

    @Override
    public boolean DisburseSalary(List<Employee_Salary> SalInfo)
    {
        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction transaction= session.beginTransaction();
            for (Object info : SalInfo)
            {
                session.save(info);
            }

            transaction.commit();
            return true;
        }
        catch (HeadlessException exception)
        {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }
    //-------- Start of Salary Disbursement by Id--------------------------
    @Override
    public boolean DisburseSalaryById(List<Employee> SalInfo)
    {

        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction transaction= session.beginTransaction();
            for (Employee info : SalInfo)
            {
                Integer EmployeeId = info.getEmployee_id();
                //Integer modifiedStatus=employee.getStatus();
                Query q = session.createQuery(" FROM Employee WHERE  employee_id= :EmployeeId ");
                q.setParameter("EmployeeId",EmployeeId);

                Employee result=(Employee)q.list().get(0);

                Float Salary=result.getSalary();

                //Inserting Data in Employee Salary...
                Employee_Salary emp_salary=new Employee_Salary();

                emp_salary.setAmount(Salary);
                emp_salary.setDescription("Salary Disbursed From Accounts-IIITB.");
                LocalDate date = LocalDate.now();
                emp_salary.setPayment_date(Date.valueOf(date));
                emp_salary.setEmployee(info);
                session.save(emp_salary);
            }

            transaction.commit();
            return true;
        }
        catch (HeadlessException exception)
        {
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }

    }
    //-----------------End of Salary Disbursement-----------------
}
