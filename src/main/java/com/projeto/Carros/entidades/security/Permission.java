package com.projeto.Carros.entidades.security;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "permission")
public class Permission implements Serializable, GrantedAuthority {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Permission that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDescription());
    }

    @Override
    public String getAuthority() {
        return this.description;
    }
}
