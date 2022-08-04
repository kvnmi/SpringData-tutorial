package com.codewithsage.Springboottutorial.Service;

import com.codewithsage.Springboottutorial.Entity.Department;
import com.codewithsage.Springboottutorial.ErrorHandler.DepartmentNotFound;
import com.codewithsage.Springboottutorial.Repository.DepartmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceInterfaceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepo departmentRepo;

    // @BeforeAll used to indicate that a method gets initiated before any other method in the class is
    @BeforeEach // This annotation ensures this block is called each time a method in this class is invoked.
    void setUp() {
        Department department = Department.builder()
                .departmentName("Computer Science")
                .departmentAddress("Random Address")
                .departmentCode("Random COde")
                .deptId(1L)
                .build();
        Mockito.when(departmentRepo.findDepartmentByDepartmentNameIgnoreCase("Computer Science"))
                .thenReturn(department); // Used to create mock data when the method is invoked
    } // Creates mock data to test with

    @Test
    @DisplayName("Get data based on valid department name")
    public void departmentName_ReturnDepartment() throws DepartmentNotFound {
        String departmentName = "Computer Science";
        Department found = departmentService.getDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    } // A test case for when departmentService.getDepartmentByName is invoked
} // You should also write test cases for when the method call fails.
