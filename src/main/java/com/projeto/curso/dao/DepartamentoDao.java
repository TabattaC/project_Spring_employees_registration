package com.projeto.curso.dao;

import com.projeto.curso.domain.Departamento;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface DepartamentoDao {
    void save(Departamento entity);

    void update(Departamento entity);

    void delete(Long id);

    Departamento findById(Long id);

    public List<Departamento> findAll();
}

