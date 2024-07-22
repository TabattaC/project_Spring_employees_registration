package com.projeto.curso.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "CARGO")
public class Cargo extends AbstractEntity<Long> {
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    private String nome;
    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;
    @OneToOne(mappedBy = "cargo")
    private List<Funcionario> funcionarios;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }


}
