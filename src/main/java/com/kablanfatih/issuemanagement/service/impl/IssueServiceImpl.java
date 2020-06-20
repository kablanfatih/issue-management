package com.kablanfatih.issuemanagement.service.impl;

import com.kablanfatih.issuemanagement.dto.IssueDto;
import com.kablanfatih.issuemanagement.entity.Issue;
import com.kablanfatih.issuemanagement.repository.IssueRepository;
import com.kablanfatih.issuemanagement.service.IssueService;
import com.kablanfatih.issuemanagement.util.TPage;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@RequiredArgsConstructor
@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Override
    public IssueDto save(IssueDto issue) {

        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Issue Date cannot be null");
        }
        Issue issueDb = modelMapper.map(issue, Issue.class);

        issueDb = issueRepository.save(issueDb);

        return modelMapper.map(issueDb, IssueDto.class);

    }

    @Override
    public IssueDto getById(Long id) {
        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return Boolean.TRUE;
    }

    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
