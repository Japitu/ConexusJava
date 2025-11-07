package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class ConsultaTO {
    private long id;
    @NotBlank
    private String status;
    @NotNull
    @PositiveOrZero
    private long idMedico;
    @NotNull
    @PositiveOrZero
    private long idPaciente;
    @NotNull
    @PositiveOrZero
    private long idChamado;

    public ConsultaTO() {}

    public ConsultaTO(long id, String status, long idMedico, long idPaciente, long idChamado) {
        this.id = id;
        this.status = status;
        this.idMedico = idMedico;
        this.idPaciente = idPaciente;
        this.idChamado = idChamado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(long idMedico) {
        this.idMedico = idMedico;
    }

    public long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public long getIdChamado() {
        return idChamado;
    }

    public void setIdChamado(long idChamado) {
        this.idChamado = idChamado;
    }
}
