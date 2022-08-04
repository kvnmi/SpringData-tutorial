package com.codewithsage.Springboottutorial.Service;

import com.codewithsage.Springboottutorial.Entity.Department;
import com.codewithsage.Springboottutorial.ErrorHandler.DepartmentNotFound;
import com.codewithsage.Springboottutorial.Repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    private final DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department saveDepartment(Department department) {
        return departmentRepo.save(department);
    }

    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }
    public Department getDepartment(Long Id) throws DepartmentNotFound {
        return departmentRepo.findById(Id).orElseThrow(() -> new DepartmentNotFound("Department not found"));
    }
    public String deleteDepartment(Long id) {
        boolean delete = departmentRepo.existsById(id);
        if (!delete) throw new IllegalStateException("Department with id " + id + " doesn't exist");
        departmentRepo.deleteById(id);
        return "Department successfully deleted";
    }

    public Department updateDepartment(Long id, Department department) {
       var db = departmentRepo.findById(id).orElseThrow(() -> new IllegalStateException("Department not found"));
        if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
            db.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
            db.setDepartmentCode(department.getDepartmentCode());
        }
        return departmentRepo.save(db);
    }

    public Department getDepartmentByName(String name) throws DepartmentNotFound {
       var department =  departmentRepo.findDepartmentByDepartmentNameIgnoreCase(name);
       if(Objects.isNull(department)) throw new DepartmentNotFound("Department with name " + name + " doesn't exist");
       return department;
    }
}
