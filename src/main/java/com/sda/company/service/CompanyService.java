package com.sda.company.service;

import com.sda.company.models.Company;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CompanyService {
    //semnatura, nu avem implementare in cazul de fata
    Company create(Company company);

    List<Company> getAll(Integer pageNumber, Integer pageSize, String sortBy);

    void deleteById(Integer id);

    Optional<Company> findById(Integer id);

    Company update(Company company);

    Company findbyNameAndRegNumber(String name, Long regNumber);

    List<Company> createAll (List<Company> companies);

}
