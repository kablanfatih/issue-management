package com.kablanfatih.issuemanagement.repository;

import com.kablanfatih.issuemanagement.entity.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long > {
}
