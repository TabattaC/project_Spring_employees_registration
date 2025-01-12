package com.projeto.curso.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "CARGO")
@SuppressWarnings("serial")
public class Cargo extends AbstractEntity<Long> {
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    @NotBlank(message = "O nome do cargo é obrigatório")
    @Size(max = 60, message = "O nome do cargo deve conter no máximo 60 caracteres.")
    private String nome;

    @NotNull(message = "Selecione o departamento relativo ao cargo.")
    @ManyToOne
    @JoinColumn(name = "id_departamento_fk")
    private Departamento departamento;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }



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
