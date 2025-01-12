package com.projeto.curso.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
@Entity
@Table(name = "DEPARTAMENTOS")
@SuppressWarnings("serial")
public class Departamento extends AbstractEntity<Long> {
    @Column(name = "nome", nullable = false, unique = true, length = 60)
    @NotBlank(message = "Informe um nome.")
    @Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres.")
    private String nome;

    @OneToMany(mappedBy = "departamento")
    private List<Cargo> cargos;

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
