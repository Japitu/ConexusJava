package br.com.fiap.to;

public class ConsultaTO {
    private long id; // id_consulta
    private String status; // st_consulta
    private long idMedico; // id_medico
    private long idPaciente; // id_paciente
    private long idChamado; // id_chamado

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
