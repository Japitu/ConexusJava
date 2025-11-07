package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.LocalDate;

public class ChamadoTO {
    private long id;
    @NotBlank
    private String tipoProblema;
    @NotNull
    @PositiveOrZero
    private int urgencia;
    @NotBlank
    private String status;
    private LocalDate dataChamado;
    @NotNull
    @PositiveOrZero
    private long idDificuldade;
    @NotNull
    @PositiveOrZero
    private long idPaciente;

    public ChamadoTO() {}

    public ChamadoTO(long id, String tipoProblema, int urgencia, String status, LocalDate dataChamado, long idDificuldade, long idPaciente) {
        this.id = id;
        this.tipoProblema = tipoProblema;
        this.urgencia = urgencia;
        this.status = status;
        this.dataChamado = dataChamado;
        this.idDificuldade = idDificuldade;
        this.idPaciente = idPaciente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataChamado() {
        return dataChamado;
    }

    public void setDataChamado(LocalDate dataChamado) {
        this.dataChamado = dataChamado;
    }

    public long getIdDificuldade() {
        return idDificuldade;
    }

    public void setIdDificuldade(long idDificuldade) {
        this.idDificuldade = idDificuldade;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
