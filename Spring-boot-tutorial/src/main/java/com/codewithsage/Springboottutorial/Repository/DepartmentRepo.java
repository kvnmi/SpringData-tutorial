package com.codewithsage.Springboottutorial.Repository;

import com.codewithsage.Springboottutorial.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  DepartmentRepo extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentNameIgnoreCase(String name);
}
