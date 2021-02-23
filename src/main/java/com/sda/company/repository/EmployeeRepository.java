package com.sda.company.repository;

import com.sda.company.models.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//anotarea @Repository nu este obligatorie, dar este bine de mentionat
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    Optional<Employee> findByFirstNameAndLastNameAndAndPersonalNumericCode(String firstName, String lastName,Long personalNumericCode);

}
