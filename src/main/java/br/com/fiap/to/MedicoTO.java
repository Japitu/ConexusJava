package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class MedicoTO {
    private long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String area;
    @PositiveOrZero
    @NotNull
    private long telefone;

    public MedicoTO() {}

    public MedicoTO(long id, String nome, String area, long telefone) {
        this.id = id;
        this.nome = nome;
        this.area = area;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
}
