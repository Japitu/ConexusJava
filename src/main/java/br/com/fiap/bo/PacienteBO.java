package br.com.fiap.bo;

import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.to.PacienteTO;

import java.util.ArrayList;

public class PacienteBO {
    private PacienteDAO pacienteDAO;

    public ArrayList<PacienteTO> findAll() {
        pacienteDAO = new PacienteDAO();
        return pacienteDAO.findAll();
    }

    public PacienteTO save (PacienteTO paciente) {
        pacienteDAO = new PacienteDAO();

        return pacienteDAO.save(paciente);
    }

    public PacienteTO findById(Long id) {
        pacienteDAO = new PacienteDAO();

        return pacienteDAO.findbyId(id);
    }

    public boolean delete (Long id) {
        pacienteDAO = new PacienteDAO();

        return pacienteDAO.delete(id);
    }

    public PacienteTO update(PacienteTO paciente) {
        pacienteDAO = new PacienteDAO();

        return pacienteDAO.update(paciente);
    }

}
