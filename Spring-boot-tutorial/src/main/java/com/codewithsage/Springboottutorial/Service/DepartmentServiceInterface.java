package com.codewithsage.Springboottutorial.Service;

import com.codewithsage.Springboottutorial.Entity.Department;
import com.codewithsage.Springboottutorial.ErrorHandler.DepartmentNotFound;

import java.util.List;

public interface DepartmentServiceInterface {
    Department saveDepartment(Department department);
    List<Department> getDepartments();

    Department getDepartment(Long Id) throws DepartmentNotFound;

    String deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);

    Department getDepartmentByName(String name) throws DepartmentNotFound;
}
