package com.kablanfatih.issuemanagement.controller;

import com.kablanfatih.issuemanagement.dto.ProjectDto;
import com.kablanfatih.issuemanagement.service.ProjectService;
import com.kablanfatih.issuemanagement.util.ApiPaths;
import com.kablanfatih.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = ApiPaths.ProjectCtrl.CTRL, description = "Project APIs")
@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable){
        TPage<ProjectDto> data = projectService.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {
        ProjectDto projectDto = projectService.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    @PostMapping()
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> store(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectService.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto project) {
        return ResponseEntity.ok(projectService.update(id, project));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectService.delete(id));
    }
}
