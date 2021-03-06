package com.sda.company.service.impl;

import com.sda.company.exception.EmployeeException;
import com.sda.company.models.Company;
import com.sda.company.models.Employee;
import com.sda.company.repository.EmployeeRepository;
import com.sda.company.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Employee> employeePage = employeeRepository.findAll(pageable);

        return employeePage.getContent();
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findbyNameAndRegNumber(String firstName, String lastName,Long personalNumericCode) {
        return employeeRepository.findByFirstNameAndLastNameAndAndPersonalNumericCode(firstName, lastName, personalNumericCode)
                .orElseThrow(() -> new EmployeeException("Employee with FirstName = " + firstName
                        + ", LastName: " + lastName + " and personalNumericCode: " + personalNumericCode + "was not found"));
    }

    @Override
    public List<Employee> createAll(List<Employee> employees) {
        return (List<Employee>) employeeRepository.saveAll(employees);
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        Optional<Employee> employeeOptional =employeeRepository.findById(id);
        if (employeeOptional.isPresent()){
            return employeeOptional;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }
}
