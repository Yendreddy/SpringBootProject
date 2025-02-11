package org.project.springBoot.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.springBoot.entity.Department;
import org.project.springBoot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentName("Data Analyst")
                        .departmentAddress("Mumbai")
                        .departmentCode("02")
                        .departmentId(UUID.fromString("751729c2-3444-400a-a981-75949fd5a085"))
                        .build();

        Mockito.when(departmentRepository.findBydepartmentNameIgnoreCase("Data Analyst"))
                .thenReturn(department);
    }

    @Test
    @DisplayName("Get Data based on Valid Department Name")
    //@Disabled
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "Data Analyst";
        Department found =
                departmentService.fetchDepartmentByName(departmentName);

        assertEquals(departmentName, found.getDepartmentName());
    }
}