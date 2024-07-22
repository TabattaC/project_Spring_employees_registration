package com.projeto.curso.Service;

import com.projeto.curso.FuncionarioDao;
import com.projeto.curso.domain.Funcionario;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService{
    private FuncionarioDao funcionarioDao;
    @Override
    @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario) {
        funcionarioDao.save(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void editar(Funcionario funcionario) {
        funcionarioDao.update(funcionario);
    }

    @Override
    @Transactional(readOnly = false)
    public void excluir(long id) {

    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return funcionarioDao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return funcionarioDao.findAll();
    }
}
