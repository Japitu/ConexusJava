package br.com.fiap.to;

import java.time.LocalDate;

public class ChamadoTO {
    private long id; // id_chamado
    private String tipoProblema; // tp_problema
    private int urgencia; // nr_urgencia
    private String status; // st_dificuldade
    private LocalDate dataChamado; // dt_chamado
    private long idDificuldade; // id_dificuldade
    private long idPaciente; // id_paciente

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
