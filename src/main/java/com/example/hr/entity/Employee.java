package com.example.hr.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;


@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    @ApiModelProperty(notes = "database generated Employee Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long id;

    @ApiModelProperty(notes = "First Name", required = true)
    @NotEmpty(message = "First name must not be empty")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @NotEmpty(message = "Last name must not be empty")
    private String lastName;

    @NotNull
    @Column(name = "salary")
    private Double salary;

    @Column(name = "email")
    @NotEmpty(message = "email must not be empty")
    @Email(message = "email should be a valid email")
    private String email;

    @Column(name = "phone_number", unique = true)
    @Size(min = 11, message = "Phone no must be 11 number")
    private String phone_number;

    @Column(name = "hire_date")
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    @JsonBackReference
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;


    public Employee(long id, String firstName, String lastName, Double salary, String email, Date hireDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.email = email;
        this.hireDate = hireDate;
    }

    public Employee() {
    }

}
