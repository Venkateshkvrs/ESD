package com.example.micro_project_esd.Bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Department
{
    @Id
    @Column
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int department_id;

    @Column(nullable = false)
    private String department_name;

    public Department(int department_id, String department_name, Integer department_capacity) {
        this.department_id = department_id;
        this.department_name = department_name;
        this.department_capacity = department_capacity;
    }

    @Column(nullable = false)
    private Integer department_capacity;
    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employee;

    public Department() {

    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public Integer getDepartment_capacity() {
        return department_capacity;
    }

    public void setDepartment_capacity(Integer department_capacity) {
        this.department_capacity = department_capacity;
    }
}
