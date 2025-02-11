package org.project.springBoot.service;

import org.project.springBoot.entity.Department;
import org.project.springBoot.error.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(UUID departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(UUID departmentId);

    public Department updateDepartment(UUID departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
