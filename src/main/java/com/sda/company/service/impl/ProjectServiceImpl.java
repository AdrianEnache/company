package com.sda.company.service.impl;

import com.sda.company.models.Department;
import com.sda.company.models.Project;
import com.sda.company.repository.ProjectRepository;
import com.sda.company.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

   private final ProjectRepository projectRepository;

   @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll(Integer pageNumber, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber,pageSize, Sort.by(sortBy));
        Page<Project> projectPage = projectRepository.findAll(pageable);

        return projectPage.getContent();
    }

    @Override
    public Optional<Project> findbyId(Long id) {
        return projectRepository.findById(id);
    }





}
