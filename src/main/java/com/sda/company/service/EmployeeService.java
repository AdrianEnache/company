package com.sda.company.service;

import com.sda.company.models.Company;
import com.sda.company.models.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    //semnatura, nu avem implementare in cazul de fata
    Employee create(Employee employee);

    List<Employee> getAll(Integer pageNumber, Integer pageSize, String sortBy);

    void deleteById(Integer id);

    Optional<Employee> findById(Integer id);

     Employee update(Employee employee);

    Employee findbyNameAndRegNumber(String firstname,String lastName, Long personalNumericCode);

    List<Employee> createAll (List<Employee> employees);

}
