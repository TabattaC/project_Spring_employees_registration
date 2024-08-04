package com.projeto.curso.Service;

import com.projeto.curso.domain.Departamento;

import java.util.List;

public interface DepartamentoService {
    void salvar(Departamento cargo);
    void editar(Departamento cargo);
    void excluir(long id);
    Departamento buscarPorId(Long id);
    List<Departamento> buscarTodos();
    boolean departamentoTemcargo(Long id);
}
