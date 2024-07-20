package com.projeto.curso.web.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity<?> that)) return false;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "id=" + id + '}';
    }
}
