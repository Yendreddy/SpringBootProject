package org.project.springBoot.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.project.springBoot.entity.Department;
import org.project.springBoot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("Bangalore")
                .departmentName("IT")
                .departmentCode("146")
                .departmentId(UUID.fromString("7f842b7c-6e36-4f21-8592-c6bde3b7567c"))
                .build();

    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("Bangalore")
                .departmentName("IT")
                .departmentCode("146")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post( "/departments")
        .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" + "\t\"departmentName\":\"IT\",\n" +
                "\t\"departmentAddress\":\"Bangalore\",\n" +
                "\t\"departmentCode\":\"146\"\n" +
                "}"))
                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(UUID.fromString("7f842b7c-6e36-4f21-8592-c6bde3b7567c")))
                .thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get( "/departments/7f842b7c-6e36-4f21-8592-c6bde3b7567c")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.departmentName")
                        .value("IT"));
    }
}