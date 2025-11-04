package br.com.fiap.bo;

import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.to.ConsultaTO;

import java.util.ArrayList;

public class ConsultaBO {
    private ConsultaDAO consultaDAO;

    public ArrayList<ConsultaTO> findAll() {
        consultaDAO = new ConsultaDAO();

        return consultaDAO.findAll();
    }

    public ConsultaTO save(ConsultaTO consulta) {
        consultaDAO = new ConsultaDAO();

        /*
        Regra de negocio:
        Status: Agendado, Realizado, Cancelado
         */

        return consultaDAO.save(consulta);
    }

    public ConsultaTO findById (Long id) {
        consultaDAO = new ConsultaDAO();

        return consultaDAO.findById(id);
    }

    public boolean delete(Long id) {
        consultaDAO = new ConsultaDAO();

        return consultaDAO.delete(id);
    }

    public ConsultaTO update(ConsultaTO consulta) {
        consultaDAO = new ConsultaDAO();

        // Colocar a mesma regra do Save

        return consultaDAO.update(consulta);
    }
}
