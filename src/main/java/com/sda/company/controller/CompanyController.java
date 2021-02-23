package com.sda.company.controller;


import com.sda.company.components.CustomFakerCompany;
import com.sda.company.models.Company;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/company")
@ControllerAdvice
public class CompanyController {

    private final CompanyService companyService;
    private final CustomFakerCompany customFaker;

    @Autowired
    public CompanyController(CompanyService companyService, CustomFakerCompany customFaker) {
        this.companyService = companyService;
        this.customFaker = customFaker;
    }

    //ResponseEntity - transpune raspunsul in JSON
    //RequestBody - primeste un JSON si il va transforma automat de catre String in obiectul dorit
    @PostMapping("/create")
    public ResponseEntity<Company> create(@RequestBody Company company){
        return ResponseEntity.ok(companyService.create(company));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Company>> getAll(@RequestParam(defaultValue = "0")Integer pageNo,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortby){
        //aici facem o metoda de tip get - nu are body
        //sort by optional
        return ResponseEntity.ok(companyService.getAll(pageNo, pageSize, sortby));
    }

    @DeleteMapping("/deleteById")
    public void deleteById(Integer id){
        companyService.deleteById(id);
    }

    @GetMapping("/findById")
    public ResponseEntity<Optional<Company>> findById(@RequestParam Integer id){
        return ResponseEntity.ok(companyService.findById(id));
    }

    @GetMapping("/findById/{id}/{name}/{age}")
    public ResponseEntity<Optional<Company>> findByPath(@PathVariable String name, @PathVariable Integer age, @PathVariable Integer id){
        return ResponseEntity.ok(companyService.findById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Company> update(@RequestBody Company company){
        return ResponseEntity.ok(companyService.update(company));
    }

    @GetMapping("/findByNameAndRegNumber")
    public ResponseEntity<Company> findByNameAndRegNumber(@RequestParam String name, @RequestParam Long regNumbe){
        return ResponseEntity.ok(companyService.findbyNameAndRegNumber(name, regNumbe));
    }

    @GetMapping("/populate")
    public void populate(){
        companyService.createAll(customFaker.createDummyCompanyList());
    }
}
