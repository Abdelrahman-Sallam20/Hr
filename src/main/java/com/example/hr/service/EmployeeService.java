package com.example.hr.service;

import com.example.hr.entity.Employee;
import com.example.hr.error.RecordNotFoundException;
import com.example.hr.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("this employee not found :- id" + id));
    }

    public List<Employee> getEmployeeByName(String firstName, String lastName) {
        return employeeRepository.findEmployeesByFirstNameOrLastName(firstName, lastName);
    }

    public List<Employee> getAllEmployeesByDepId(Integer depId) {
        return employeeRepository.findEmployeesByDepId(depId);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
