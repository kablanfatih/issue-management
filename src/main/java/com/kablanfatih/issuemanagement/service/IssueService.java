package com.kablanfatih.issuemanagement.service;

import com.kablanfatih.issuemanagement.dto.IssueDto;
import com.kablanfatih.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);
}
