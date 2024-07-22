package com.projeto.curso.dao;

import com.projeto.curso.domain.Cargo;
import java.util.List;

public interface CargoDao {
    void save(Cargo entity);

    void update(Cargo entity);

    void delete(Long id);

    Cargo findById(Long id);

    public List<Cargo> findAll();
}
