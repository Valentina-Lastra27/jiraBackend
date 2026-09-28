package com.example.jirabackend.repository;

import com.example.jirabackend.Model.bug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BugRepository extends JpaRepository<bug, Long> {
}