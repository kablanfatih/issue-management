package com.kablanfatih.issuemanagement.service.impl;

import com.kablanfatih.issuemanagement.entity.Project;
import com.kablanfatih.issuemanagement.repository.ProjectRepository;
import com.kablanfatih.issuemanagement.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Override
    public Project save(Project project) {
        if (project == null) {
            throw new IllegalArgumentException("Project Code cannot be null");
        }
        return projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
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
}
