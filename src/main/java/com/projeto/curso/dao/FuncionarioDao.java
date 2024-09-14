package com.projeto.curso.dao;

import com.projeto.curso.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario entity);

    void update(Funcionario entity);

    void delete(Long id);

    Funcionario findById(Long id);

    public List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);
}
