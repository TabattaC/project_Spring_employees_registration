package com.projeto.curso.dao;

import com.projeto.curso.domain.Funcionario;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario,Long> implements FuncionarioDao {
}
