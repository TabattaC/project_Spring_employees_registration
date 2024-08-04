package com.projeto.curso.dao;

import com.projeto.curso.domain.Departamento;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartamentoDao {
    void save(Departamento entity);

    void update(Departamento entity);

    void delete(Long id);

    Departamento findById(Long id);

    public List<Departamento> findAll();
}

