package com.example.hr.controller;

import com.example.hr.entity.Department;
import com.example.hr.service.DepartmentService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/department")
@Api(value = "department", description = "operations for Department Service")
public class DepartmentController {

    DepartmentService departmentService;

    @GetMapping(path = "/list")
    public List<Department> getAllDepartment() {
        return departmentService.getAllDepartments();
    }

    @GetMapping(path = "/find")
    public Department findById(@RequestParam(name = "id") Integer depId) {
        return departmentService.getDepartmentById(depId);
    }

    @Transactional
    @PostMapping(path = "/new")
    public Department addDepartment(@RequestBody Department department) {
        departmentService.addDepartment(department);
        return department;
    }

    @PutMapping(path = "/update")
    public Department updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);
        return department;
    }


    @DeleteMapping(path = "/delete")
    public String deleteDepartment(@RequestParam(name = "id") Integer id) {
        departmentService.deleteDepartment(id);
        return "Successfully deleted";
    }
}
