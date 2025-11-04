package br.com.fiap.to;

import java.time.LocalDate;

public class DificuldadeTO {
    private long id;
    private long idPaciente;
    private String status;
    private LocalDate dataDificuldade;
    private String descricao;

    public DificuldadeTO() {}

    public DificuldadeTO(long id, long idPaciente, String status, LocalDate dataDificuldade, String descricao) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.status = status;
        this.dataDificuldade = dataDificuldade;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataDificuldade() {
        return dataDificuldade;
    }

    public void setDataDificuldade(LocalDate dataDificuldade) {
        this.dataDificuldade = dataDificuldade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
