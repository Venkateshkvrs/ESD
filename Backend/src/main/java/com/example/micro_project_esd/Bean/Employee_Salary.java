package com.example.micro_project_esd.Bean;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class Employee_Salary
{
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Date payment_date;

    @Column(nullable = false)
    private Float amount;

    @Column
    private String description;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Employee_Salary(Date payment_date, Float amount, String description, Employee employee) {
        this.payment_date = payment_date;
        this.amount = amount;
        this.description = description;
        this.employee = employee;
    }

    public Employee_Salary() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
