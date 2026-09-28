package com.example.jirabackend.repository;

import com.example.jirabackend.Model.HistoriaDeUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriaDeUsuarioRepository extends JpaRepository<HistoriaDeUsuario, Long> {
}