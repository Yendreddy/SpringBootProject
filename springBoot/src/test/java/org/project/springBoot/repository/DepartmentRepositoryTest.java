package org.project.springBoot.repository;

import org.junit.jupiter.api.BeforeEach;
import org.project.springBoot.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("IT")
                        .departmentAddress("Bangalore")
                        .departmentCode("146")
                        .build();

        entityManager.persist(department);
    }

    public void whenFindById_thenReturnDepartment(){
        Department department = departmentRepository.findById(UUID.fromString("7f842b7c-6e36-4f21-8592-c6bde3b7567c")).get();
        assertEquals(department.getDepartmentName(), "IT");
    }
}