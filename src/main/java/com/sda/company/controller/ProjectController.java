package com.sda.company.controller;


import com.sda.company.models.Project;
import com.sda.company.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
@ControllerAdvice
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //ResponseEntity - transpune raspunsul in JSON
    //RequestBody - primeste un JSON si il va transforma automat de catre String in obiectul dorit
    @PostMapping("/create")
    public ResponseEntity<Project> create(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.create(project));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Project>> getAll(@RequestParam(defaultValue = "0") Integer pageNom,
                                                @RequestParam(defaultValue = "10") Integer pageSize,
                                                @RequestParam(defaultValue = "id") String sortby) {
        return ResponseEntity.ok(projectService.getAll(pageNom, pageSize, sortby));
    }


    @GetMapping("/findById")
    public ResponseEntity<Optional<Project>> findById(Long id) {
        return ResponseEntity.ok(projectService.findbyId(id));
    }
}

