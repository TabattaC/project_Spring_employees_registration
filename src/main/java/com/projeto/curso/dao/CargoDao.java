package com.projeto.curso.dao;

import com.projeto.curso.domain.Cargo;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CargoDao {
    void save(Cargo entity);

    void update(Cargo entity);

    void delete(Long id);

    Cargo findById(Long id);

    public List<Cargo> findAll();
}
