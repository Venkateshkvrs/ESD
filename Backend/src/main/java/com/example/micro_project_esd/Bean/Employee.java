package com.example.micro_project_esd.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.query.Query;

import java.util.List;

@Entity
@Table
public class Employee
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(nullable = false)
    private String fname;

    @Column
    private String lname;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private Float salary;

    @Column
    private String title;

    @Column
    private String photograph_path;

    @Column
    private  String password;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    private Integer status;

    public Employee() {

    }

    public Employee(Query employee_id) {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotograph_path() {
        return photograph_path;
    }

    public void setPhotograph_path(String photograph_path) {
        this.photograph_path = photograph_path;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Employee(int employee_id, String fname, String lname, String email, Float salary, String title, String photograph_path, String password, Department department, Integer status) {
        this.employee_id = employee_id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.salary = salary;
        this.title = title;
        this.photograph_path = photograph_path;
        this.password = password;
        this.department = department;
        this.status= status;
    }



}
