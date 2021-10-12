package com.example.hr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "departments")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Integer id;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Jobs jobs;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @Column(name = "location_id")
    private Integer locationId;


    @OneToMany(
            mappedBy = "department",
            targetEntity = Employee.class
    )
    private List<Employee> employeeList;

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {
    }
}
