package com.example.trabalho_suficiencia.repository;

import com.example.trabalho_suficiencia.entity.ComandaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<ComandaEntity, Long> {

}