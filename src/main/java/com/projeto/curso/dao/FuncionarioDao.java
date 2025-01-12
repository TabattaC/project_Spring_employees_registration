package com.projeto.curso.dao;

import com.projeto.curso.domain.Funcionario;

import java.time.LocalDate;
import java.util.List;

public interface FuncionarioDao {

    void save(Funcionario entity);

    void update(Funcionario entity);

    void delete(Long id);

    Funcionario findById(Long id);

    public List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargoId(Long id);

    List<Funcionario> findByDataEntrada(LocalDate entrada);

    List<Funcionario> findByDataSaida(LocalDate saida);

    List<Funcionario> findByDataEntradaSaida(LocalDate entrada, LocalDate saida);
}
