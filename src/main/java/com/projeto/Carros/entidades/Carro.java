package com.projeto.Carros.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name = "Carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "Modelo", nullable = false)
    private String modelo;

    @NotBlank
    @Column(name = "Ano", nullable = false)
    private String ano;

    @NotBlank
    @Column(name = "Cor")
    private String cor;

    @NotBlank
    @Column(name = "Placa", unique = true)
    private String placa;

    @Column(name = "Motorizacao")
    private String motorizacao;

    public Carro() {
    }

    public Carro(String ano, String cor, Long id, String modelo, String motorizacao, String placa) {
        this.ano = ano;
        this.cor = cor;
        this.id = id;
        this.modelo = modelo;
        this.motorizacao = motorizacao;
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotorizacao() {
        return motorizacao;
    }

    public void setMotorizacao(String motorizacao) {
        this.motorizacao = motorizacao;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Carro carro)) return false;
        return Objects.equals(getId(), carro.getId()) && Objects.equals(getModelo(), carro.getModelo())
                && Objects.equals(getAno(), carro.getAno()) && Objects.equals(getCor(), carro.getCor())
                && Objects.equals(getPlaca(), carro.getPlaca()) && Objects.equals(getMotorizacao(),
                carro.getMotorizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModelo(), getAno(), getCor(), getPlaca(), getMotorizacao());
    }



}
