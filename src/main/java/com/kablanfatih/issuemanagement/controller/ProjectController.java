package com.kablanfatih.issuemanagement.controller;

import com.kablanfatih.issuemanagement.dto.ProjectDto;
import com.kablanfatih.issuemanagement.service.ProjectService;
import com.kablanfatih.issuemanagement.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        ProjectDto projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping()
    public ResponseEntity<ProjectDto> store(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.save(projectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectService.update(id, project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectService.delete(id));
    }
}
