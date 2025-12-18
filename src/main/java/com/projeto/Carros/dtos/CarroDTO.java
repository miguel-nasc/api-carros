package com.projeto.Carros.dtos;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;

public class CarroDTO extends RepresentationModel<CarroDTO> {
    private Long id;
    private String modelo;
    private String ano;
    private String cor;
    private String placa;
    private String motorizacao;

    public CarroDTO(String ano, Long id, String modelo, String motorizacao, String placa) {
        this.ano = ano;
        this.id = id;
        this.modelo = modelo;
        this.motorizacao = motorizacao;
        this.placa = placa;
    }

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CarroDTO carroDTO)) return false;
        return Objects.equals(getId(), carroDTO.getId()) && Objects.equals(getModelo(), carroDTO.getModelo()) && Objects.equals(getAno(), carroDTO.getAno()) && Objects.equals(getCor(), carroDTO.getCor()) && Objects.equals(getPlaca(), carroDTO.getPlaca()) && Objects.equals(getMotorizacao(), carroDTO.getMotorizacao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModelo(), getAno(), getCor(), getPlaca(), getMotorizacao());
    }


}