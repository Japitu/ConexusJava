package br.com.fiap.bo;

import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.to.MedicoTO;

import java.util.ArrayList;

public class MedicoBO {
    private MedicoDAO medicoDAO;

    public ArrayList<MedicoTO> findAll() {
        medicoDAO = new MedicoDAO();

        return medicoDAO.findAll();
    }

    public MedicoTO save(MedicoTO medico) {
        medicoDAO = new MedicoDAO();

        /*
        Regra de negocio de:
        Area: Nutricionista, Psicologo, Fisioterapeuta
        Numero telefone: abaixo de 100000000000
        */
        return medicoDAO.save(medico);
    }

    public MedicoTO findById(Long id) {
        medicoDAO = new MedicoDAO();

        return medicoDAO.findById(id);
    }

    public boolean delete (Long id) {
        medicoDAO = new MedicoDAO();

        return medicoDAO.delete(id);
    }

    public MedicoTO update(MedicoTO medico) {
        medicoDAO = new MedicoDAO();

        // Colocar as mesmas regras do Save

        return medicoDAO.update(medico);
    }
}
