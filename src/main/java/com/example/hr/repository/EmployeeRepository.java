package com.example.hr.repository;

import com.example.hr.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeesByFirstNameOrLastName(String firstName, String lastName);

    @Query(value = "select * from employees e where e.department_id =?1", nativeQuery = true)
    List<Employee> findEmployeesByDepId(Integer depId);
}
