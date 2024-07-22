package com.projeto.curso.Service;

import com.projeto.curso.dao.CargoDao;
import com.projeto.curso.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoDao cargoDao;
    @Override
    public void salvar(Cargo cargo) {
        cargoDao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
        cargoDao.update(cargo);
    }

    @Override
    public void excluir(long id) {
        cargoDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return cargoDao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return cargoDao.findAll();
    }
}
