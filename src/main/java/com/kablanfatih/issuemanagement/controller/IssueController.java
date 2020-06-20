package com.kablanfatih.issuemanagement.controller;

import com.kablanfatih.issuemanagement.dto.IssueDto;
import com.kablanfatih.issuemanagement.service.IssueService;
import com.kablanfatih.issuemanagement.util.ApiPaths;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {

    private final IssueService issueService;

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable("id") Long id) {
        IssueDto issueDto = issueService.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping()
    public ResponseEntity<IssueDto> store(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueService.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueService.update(id, issue));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueService.delete(id));
    }
}
