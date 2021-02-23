package com.sda.company.service.impl;

import com.sda.company.exception.CompanyException;
import com.sda.company.models.Company;
import com.sda.company.repository.CompanyRepository;
import com.sda.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;



    @Autowired
    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Company create(Company company) {
       return companyRepository.save(company);
    }

    @Override
    public List<Company> getAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Company> companyPage = companyRepository.findAll(pageable);

        return companyPage.getContent();
    }

    @Override
    public void deleteById(Integer id) {
        companyRepository.deleteById(id);
    }

    @Override
    public Optional<Company> findById(Integer id) {
        Optional<Company> companyOptional = companyRepository.findById(id);
        if (companyOptional.isPresent()){
            return companyOptional;
        }else {
            return Optional.empty();
        }
    }

    public Company update(Company company) {
        return companyRepository.save(company);
    }

    @Override
    public Company findbyNameAndRegNumber(String name, Long regNumber) {
        return companyRepository.findByNameAndRegistrationNumber(name,regNumber)
                .orElseThrow(() -> new CompanyException("Company with Name = " + name
                        + " and registration Number: " + regNumber + "was not found"));
    }

    @Override
    public List<Company> createAll(List<Company> companies) {
       return (List<Company>) companyRepository.saveAll(companies);
    }
}
