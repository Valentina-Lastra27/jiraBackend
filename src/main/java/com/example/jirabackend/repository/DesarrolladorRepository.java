package com.example.jirabackend.repository;

import com.example.jirabackend.Model.Desarrollador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesarrolladorRepository extends JpaRepository<Desarrollador, Long> {
}