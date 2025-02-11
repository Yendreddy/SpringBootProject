package org.project.springBoot.repository;

import org.project.springBoot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    public Department findBydepartmentName(String departmentName);

    @Query(value = "", nativeQuery = true)
    public Department findBydepartmentNameIgnoreCase(String departmentName);
}
