package com.sda.company.controller;


import com.sda.company.models.Department;
import com.sda.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
@ControllerAdvice
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;

    }

    //ResponseEntity - transpune raspunsul in JSON
    //RequestBody - primeste un JSON si il va transforma automat de catre String in obiectul dorit
    @PostMapping("/create")
    public ResponseEntity<Department> create(@RequestBody Department department) {
        return ResponseEntity.ok(departmentService.create(department));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Department>> getAll(@RequestParam(defaultValue = "0") Integer pageNom,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(defaultValue = "id") String sortby) {
        return ResponseEntity.ok(departmentService.getAll(pageNom, pageSize, sortby));
    }



    @GetMapping("/findById")
    public ResponseEntity<Optional<Department>> findById(Long id) {
        return ResponseEntity.ok(departmentService.findbyId(id));
    }



}
