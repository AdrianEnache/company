package com.sda.company.service;

import com.sda.company.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {

    Department create(Department department);

    List<Department> getAll(Integer pageNumber, Integer pageSize, String sortBy);

    Optional<Department> findbyId(Long id);


}
