package com.kablanfatih.issuemanagement.service;

import com.kablanfatih.issuemanagement.dto.ProjectDto;
import com.kablanfatih.issuemanagement.entity.Project;
import com.kablanfatih.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto user);

    ProjectDto getById(Long id);

    Project getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto project);

}
