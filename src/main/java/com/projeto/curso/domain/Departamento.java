package com.projeto.curso.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;
    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
