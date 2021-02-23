package com.sda.company.service.impl;

import com.sda.company.models.Department;
import com.sda.company.models.Project;
import com.sda.company.repository.DepartmentRepository;
import com.sda.company.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Department> departmentPage = departmentRepository.findAll(pageable);

        return departmentPage.getContent();
    }

    @Override
    public Optional<Department> findbyId(Long id) {
            return departmentRepository.findById(id);
    }
}
