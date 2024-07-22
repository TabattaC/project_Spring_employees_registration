package com.projeto.curso.Service;

import com.projeto.curso.domain.Cargo;

import java.util.List;

public interface CargoService {

    void salvar(Cargo cargo);
    void editar(Cargo cargo);
    void excluir(long id);
    Cargo buscarPorId(Long id);
    List<Cargo>buscarTodos();
}
