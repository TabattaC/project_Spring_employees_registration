package com.projeto.curso;

import com.projeto.curso.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario entity);

    void update(Funcionario entity);

    void delete(Long id);

    Funcionario findById(Long id);

    public List<Funcionario> findAll();
}
