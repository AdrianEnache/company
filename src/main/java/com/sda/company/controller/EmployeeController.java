package com.sda.company.controller;


import com.sda.company.components.CustomFakerEmployee;
import com.sda.company.models.Employee;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@ControllerAdvice
public class EmployeeController {

    private final EmployeeService employeeService;
    private final CustomFakerEmployee customFakerEmployee;

    @Autowired
    public EmployeeController(EmployeeService employeeService, CustomFakerEmployee customFakerEmployee) {
        this.customFakerEmployee = customFakerEmployee;
        this.employeeService = employeeService;
    }

    //ResponseEntity - transpune raspunsul in JSON
    //RequestBody - primeste un JSON si il va transforma automat de catre String in obiectul dorit
    @PostMapping("/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.create(employee));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAll(@RequestParam(defaultValue = "0") Integer pageNom,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam String sortby) {
        return ResponseEntity.ok(employeeService.getAll(pageNom, pageSize, sortby));
    }

    @DeleteMapping("/deleteById")
    public void deleteById(Integer id) {
        employeeService.deleteById(id);
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<Employee>> findById(Integer id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.update(employee));
    }

    @GetMapping("/findByNameAndRegNumber")
    public ResponseEntity<Employee> findByNameAndRegNumber(@RequestParam String firstName,
                                                           @RequestParam String lastName,
                                                           @RequestParam Long regNumbe) {
        return ResponseEntity.ok(employeeService.findbyNameAndRegNumber(firstName, lastName, regNumbe));
    }

    @GetMapping("/populate")
    public void populate() {
        employeeService.createAll(customFakerEmployee.createDummyCompanyList());
    }


    @PutMapping("/assignDepartment")
    public ResponseEntity<Employee> assignDepartment(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(employee));
    }

    @PutMapping("/assignProject")
    public ResponseEntity<Employee> assignProject(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.update(employee));
    }
}
