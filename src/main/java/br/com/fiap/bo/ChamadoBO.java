package br.com.fiap.bo;

import br.com.fiap.dao.ChamadoDAO;
import br.com.fiap.to.ChamadoTO;

import java.util.ArrayList;

public class ChamadoBO {
    private ChamadoDAO chamadoDAO;

    public ArrayList<ChamadoTO> findAll() {
        chamadoDAO = new ChamadoDAO();

        return chamadoDAO.findAll();
    }

    public ChamadoTO save(ChamadoTO chamado) {
        chamadoDAO = new ChamadoDAO();

        /*
        Colocar Regra de negocio de:
        Tipo Problema: Ver alguns tipos
        Urgencia: 0 - 10
        Status: Agendado, Em andamento, Finalizado, Cancelado
        */

        return chamadoDAO.save(chamado);
    }

    public ChamadoTO findById (Long id) {
        chamadoDAO = new ChamadoDAO();

        return chamadoDAO.findById(id);
    }

    public boolean delete(Long id) {
        chamadoDAO = new ChamadoDAO();

        return chamadoDAO.delete(id);
    }

    public ChamadoTO update(ChamadoTO chamado) {
        chamadoDAO = new ChamadoDAO();

        // Colocar a mesma regra do Save

        return chamadoDAO.update(chamado);
    }

}
