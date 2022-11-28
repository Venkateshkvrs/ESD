package com.example.micro_project_esd.DAO.DAOImplementation;

import com.example.micro_project_esd.Bean.Department;
import com.example.micro_project_esd.DAO.DepartmentDAO;
import com.example.micro_project_esd.util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.*;

public class DepartmentDAOimpl implements DepartmentDAO {
    @Override
    public boolean addDepartment(Department deptObj)
    {
        try(Session session= HibernateSessionUtil.getSession())
        {
            Transaction transaction= session.beginTransaction();
            session.save(deptObj);
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

}
