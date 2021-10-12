package com.example.hr.controller;

import com.example.hr.entity.Employee;
import com.example.hr.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping(path = "/list")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/find")
    public Employee findById(@RequestParam(name = "empId") Long empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping(path = "/new")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping(path = "/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return employee;
    }


    @DeleteMapping(path = "/delete")
    public String deleteEmployee(@RequestParam Long id) {
        employeeService.deleteEmployee(id);
        return "Successfully deleted";
    }

    @GetMapping(path = "/find-employess-by-name")
    public List<Employee> findEmplyeesByName(@RequestParam(name = "empName") String empName) {
        return employeeService.getEmployeeByName(empName, empName);
    }

    @GetMapping(path = "/get-employees-by-depId")
    public List<Employee> getEmployeeByDepId(@RequestParam(name = "depId") Integer depId) {
        return employeeService.getAllEmployeesByDepId(depId);
    }


}
