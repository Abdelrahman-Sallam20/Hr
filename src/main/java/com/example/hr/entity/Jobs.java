package com.example.hr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "jobs")
@Data
public class Jobs {

    @Id
    @Column(name = "job_id")
    private String id;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "min_salary")
    private String minSalary;

    @Column(name = "max_salary")
    private String maxSalary;

    @OneToMany(
            mappedBy = "jobs",
            targetEntity = Employee.class
    )
    private List<Employee> employeeList;

    @OneToMany(
            mappedBy = "jobs",
            targetEntity = Department.class
    )
    private List<Department> departmentList;

    public Jobs(String id, String jobTitle, String minSalary, String maxSalary) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    public Jobs() {
    }
}
