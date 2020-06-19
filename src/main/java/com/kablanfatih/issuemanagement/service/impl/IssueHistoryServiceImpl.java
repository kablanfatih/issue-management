package com.kablanfatih.issuemanagement.service.impl;

import com.kablanfatih.issuemanagement.entity.IssueHistory;
import com.kablanfatih.issuemanagement.repository.IssueHistoryRepository;
import com.kablanfatih.issuemanagement.service.IssueHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    @Override
    public IssueHistory save(IssueHistory issueHistory) {

        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue cannot be null");
        }
        return issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAllPageable(Pageable pageable) {
        return issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Long id) {
        issueHistoryRepository.deleteById(id);
        return Boolean.TRUE;
    }
}
