package com.codewithsage.Springboottutorial.Repository;

import com.codewithsage.Springboottutorial.Entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // Annotation would ensure that data is cleaned from db after execution. Since it's just test data
class DepartmentRepoTest {

    @Autowired
    private DepartmentRepo departmentRepo;
    @Autowired
     public TestEntityManager testEntityManager;


    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("Computer Science")
                .departmentAddress("Random Address")
                .departmentCode("Random COde")
                .build();

        testEntityManager.persist(department);
    }

    @Test
    public void findByID_ReturnDepartment() {
        Department department = departmentRepo.findById(1L).get();

        assertEquals(department.getDepartmentName(), "Computer Science");
    }
    @Test
    public void findByName_ReturnDepartment() {
        Department department = departmentRepo.findDepartmentByDepartmentNameIgnoreCase("Computer Science");

        assertEquals(department.getDepartmentName(), "Computer Science");
    }
}
