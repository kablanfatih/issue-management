package com.kablanfatih.issuemanagement.repository;

import com.kablanfatih.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue, Long > {
}
