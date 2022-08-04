package com.codewithsage.Springboottutorial.Controller;

import com.codewithsage.Springboottutorial.Entity.Department;
import com.codewithsage.Springboottutorial.ErrorHandler.DepartmentNotFound;
import com.codewithsage.Springboottutorial.Service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    private final DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping()
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("New department created by DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping()
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("/{id}")
    public Department getADepartment(@PathVariable("id") Long Id) throws DepartmentNotFound {
        return departmentService.getDepartment(Id);
    }

    @GetMapping("getByName/{name}")
    public Department getADepartment(@PathVariable("name") String name) throws DepartmentNotFound {
        return departmentService.getDepartmentByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long Id) {
        LOGGER.info("New department deleted by DepartmentController");
        return departmentService.deleteDepartment(Id);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable("id") Long id, @RequestBody Department department) {
        LOGGER.info("New department edited by DepartmentController");
        return departmentService.updateDepartment(id, department);
    }
}

