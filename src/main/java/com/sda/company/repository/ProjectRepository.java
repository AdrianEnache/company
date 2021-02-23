package com.sda.company.repository;

import com.sda.company.models.Project;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project,Long> {

    Optional<Project> findByNameAndId(String name, Long id);
}
