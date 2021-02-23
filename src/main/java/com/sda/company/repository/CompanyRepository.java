package com.sda.company.repository;

import com.sda.company.models.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//anotarea @Repository nu este obligatorie, dar este bine de mentionat
@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company,Integer> {

    Optional<Company> findByNameAndRegistrationNumber(String name, Long registrationNumber);

}
