package com.kablanfatih.issuemanagement.service.impl;

import com.kablanfatih.issuemanagement.dto.ProjectDto;
import com.kablanfatih.issuemanagement.entity.Project;
import com.kablanfatih.issuemanagement.repository.ProjectRepository;
import com.kablanfatih.issuemanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Project checkProject = projectRepository.getByProjectCode(projectDto.getProjectCode());

        if (checkProject != null){
            throw new IllegalArgumentException("Not Unique");
        }

        Project project = modelMapper.map(projectDto, Project.class);
        project =  projectRepository.save(project);
        projectDto.setId(project.getId());
        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project p = projectRepository.getOne(id);
        return modelMapper.map(p, ProjectDto.class);
    }

    @Override
    public Project getByProjectCode(String projectCode) {
        return projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return getAllPageable(pageable);
    }

    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {
        Project projectDb = projectRepository.getOne(id);
        if (projectDb == null)
            throw new IllegalArgumentException("Project Does Not Exist ID:" + id);

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);
        if (projectCheck != null)
            throw new IllegalArgumentException("Project Code Already Exist");

        projectDb.setProjectCode(projectDto.getProjectCode());
        projectDb.setProjectName(projectDto.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }
}
