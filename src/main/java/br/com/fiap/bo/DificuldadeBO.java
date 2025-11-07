package br.com.fiap.bo;

import br.com.fiap.dao.DificuldadeDAO;
import br.com.fiap.to.DificuldadeTO;

import java.util.ArrayList;

public class DificuldadeBO {
    private DificuldadeDAO dificuldadeDAO;

    public ArrayList<DificuldadeTO> findAll() {
        dificuldadeDAO = new DificuldadeDAO();

        return dificuldadeDAO.findAll();
    }

    public DificuldadeTO save(DificuldadeTO dificuldade) {
        dificuldadeDAO = new DificuldadeDAO();

        return dificuldadeDAO.save(dificuldade);
    }

    public DificuldadeTO findById(Long id) {
        dificuldadeDAO = new DificuldadeDAO();

        return dificuldadeDAO.findById(id);
    }

    public boolean delete(Long id) {
        dificuldadeDAO = new DificuldadeDAO();

        return dificuldadeDAO.delete(id);
    }

    public DificuldadeTO update(DificuldadeTO dificuldade) {
        dificuldadeDAO = new DificuldadeDAO();

        return dificuldadeDAO.update(dificuldade);
    }
}
