package com.projeto.Carros.dtos;

import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;
import java.util.Objects;

public class CarroDTO extends RepresentationModel<CarroDTO> {
    private Long id;
    @NotBlank
    private String marca;
    @NotBlank
    private String modelo;
    @NotBlank
    private String ano;
    @NotBlank
    private String cor;
    @NotBlank
    private String placa;
    @NotBlank
    private String motorizacao;

    public CarroDTO() {
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarroDTO carroDTO)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), carroDTO.getId()) && Objects.equals(marca, carroDTO.marca) && Objects.equals(getModelo(), carroDTO.getModelo()) && Objects.equals(getAno(), carroDTO.getAno()) && Objects.equals(getCor(), carroDTO.getCor()) && Objects.equals(getPlaca(), carroDTO.getPlaca()) && Objects.equals(getMotorizacao(), carroDTO.getMotorizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), marca, getModelo(), getAno(), getCor(), getPlaca(), getMotorizacao());
    }
}