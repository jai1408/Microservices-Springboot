package com.jai1408.department.service;

import com.jai1408.department.entity.Department;
import com.jai1408.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

  @Autowired private DepartmentRepository departmentRepository;

  public Department saveDepartment(Department department) {
    log.info("inside saveDepartment() of DepartmentService");
    return departmentRepository.save(department);
  }

  public Department findDepartmentById(Long departmentId) {
      log.info("inside findDepartmentById() of DepartmentService");
    Department department = null;
    log.info("inside findDepartmentById of DepartmentService");
    Optional<Department> optionalDepartment = departmentRepository.findById(departmentId);
    if (optionalDepartment.isPresent()) {
      department = optionalDepartment.get();
    }
    return department;
  }
}
