package com.example.hr.controller;

import com.example.hr.entity.Employee;
import com.example.hr.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/emp")
@Api(value = "employee", description = "operations for Employee Service")
public class EmployeeController {

    EmployeeService employeeService;

    @GetMapping(path = "/list")
    @ApiOperation(value = "View list of employee", response = Employee.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view list"),
            @ApiResponse(code = 403, message = "forbidden to access"),
            @ApiResponse(code = 404, message = "resource not found"),
    })
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "/find")
    public Employee findById(@RequestParam(name = "empId") Long empId) {
        return employeeService.findById(empId);
    }

    @PostMapping(path = "/new")
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }


    @DeleteMapping(path = "/delete")
    public String deleteEmployee(@RequestParam(name = "id") Long id) {
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
