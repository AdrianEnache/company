package com.sda.company.service;

import com.sda.company.models.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProjectService {

    Project create(Project project);

    List<Project> getAll(Integer pageNumber, Integer pageSize, String sortBy);

    Optional<Project> findbyId(Long id);


}
