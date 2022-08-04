package com.codewithsage.Springboottutorial.Controller;

import com.codewithsage.Springboottutorial.Entity.Department;
import com.codewithsage.Springboottutorial.ErrorHandler.DepartmentNotFound;
import com.codewithsage.Springboottutorial.Service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class) // TO test controllers
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private Department department;
    @MockBean
    private DepartmentService departmentService;

    @BeforeEach
    public void setUp() {
        department = Department.builder()
                .departmentName("Computer Science")
                .departmentAddress("Random Address")
                .departmentCode("Random COde")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        var inputDepartment = Department.builder()
                .departmentName("Computer Science")
                .departmentAddress("Random Address")
                .departmentCode("Random COde")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/departments").contentType(MediaType.APPLICATION_JSON).content("""
                {
                \t"departmentName": "Computer Science",
                \t"departmentCode": "Random COde",
                \t"departmentAddress": "Random Address"
                }""")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getADepartment() throws Exception {
        Mockito.when(departmentService.getDepartment(1L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/departments/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers
                        .jsonPath("$.departmentName")
                        .value(department.getDepartmentName()));
    }
}
