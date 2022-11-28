package com.example.micro_project_esd.DAO.DAOImplementation;

import com.example.micro_project_esd.Bean.Department;
import com.example.micro_project_esd.Bean.Employee;
import com.example.micro_project_esd.Bean.Employee_Salary;
import com.example.micro_project_esd.DAO.EmployeeDAO;
import com.example.micro_project_esd.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOimpl implements EmployeeDAO
{
    @Override
    public boolean AddEmployee(Employee EmpObj)
    {
        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction transaction= session.beginTransaction();
            session.save(EmpObj);
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

    @Override
    public Employee login_with_employee(Employee employee)
    {
        try (Session session = HibernateSessionUtil.getSession())
        {
            List<Employee> employeeList = new ArrayList<>(
              session.createQuery("FROM Employee  where email= :email and password= :password")
                      .setParameter("email",employee.getEmail())
                      .setParameter("password",employee.getPassword()).list()
            );
            Department dept = employeeList.get(0).getDepartment();
            List<Employee> result = new ArrayList<>(
                    session.createQuery("FROM Employee where email= :email and password= :password and department.department_name= :department_name")
                            .setParameter("email",employee.getEmail())
                            .setParameter("password",employee.getPassword())
                            .setParameter("department_name","Accounts").list()
            );
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public Boolean modify_salary(Employee employee)
    {
        try (Session session = HibernateSessionUtil.getSession())
        {
            Transaction t = session.beginTransaction();
            Integer EmployeeId = employee.getEmployee_id();
            Float modifiedSalary=employee.getSalary();
            if(modifiedSalary < 0) return  false;
            Query q = session.createQuery(" FROM Employee WHERE  employee_id= :EmployeeId ");
            q.setParameter("EmployeeId",EmployeeId);
            Employee result=(Employee)q.list().get(0);
            result.setSalary(modifiedSalary);
            session.update(result);
            t.commit();
            if(result==null)
            {
                return false;
            }
            return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
        }

        return false;
    }

    @Override
    public Boolean modify_status(Employee employee)
    {
        try (Session session = HibernateSessionUtil.getSession())
        {
            Transaction t = session.beginTransaction();
            Integer EmployeeId = employee.getEmployee_id();
            Integer modifiedStatus=employee.getStatus();
            Query q = session.createQuery(" FROM Employee WHERE  employee_id= :EmployeeId ");
            q.setParameter("EmployeeId",EmployeeId);
            Employee result=(Employee)q.list().get(0);
            result.setStatus(modifiedStatus);
            session.update(result);
            t.commit();
            if(result==null)
            {
                return false;
            }
            return true;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
        }

        return false;
    }
    @Override
    public List<Employee> Employee_Details()
    {
        try (Session session = HibernateSessionUtil.getSession())
        {
            List<Employee> employeeList=new ArrayList<>(session.createQuery("FROM Employee").list());
            if (employeeList.size() == 0)
                return null;
            else
                return employeeList;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }

    @Override
    public List<Employee> one_Employee_Details(int employee_id)
    {

//        Integer emp = employee.getEmployee_id();
        try (Session session = HibernateSessionUtil.getSession())
        {
            List<Employee> employeeList=new ArrayList<>(session.createQuery("FROM Employee WHERE employee_id=:employee_id")
                    .setParameter("employee_id", employee_id)
                    .list());
            if (employeeList.size() == 0)
                return null;
            else
                return employeeList;
        }
        catch (HibernateException exception)
        {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }


}
