package com.kablanfatih.issuemanagement.service;

import com.kablanfatih.issuemanagement.dto.ProjectDto;
import com.kablanfatih.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto user);

    ProjectDto getById(Long id);

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto project);

}
