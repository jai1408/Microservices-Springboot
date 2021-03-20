package com.jai1408.department.controller;

import com.jai1408.department.entity.Department;
import com.jai1408.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

  @Autowired private DepartmentService departmentService;

  @PostMapping("/")
  public Department saveDepartment(@RequestBody Department department) {
    log.info("inside saveDepartment() of DepartmentController");
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/{departmentId}")
  public Department findDepartmentById(@PathVariable Long departmentId){
    log.info("inside findDepartmentById() of DepartmentController");
    return departmentService.findDepartmentById(departmentId);
  }
}
