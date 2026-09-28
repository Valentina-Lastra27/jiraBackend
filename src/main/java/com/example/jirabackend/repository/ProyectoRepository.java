package com.example.jirabackend.repository;

import com.example.jirabackend.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
}