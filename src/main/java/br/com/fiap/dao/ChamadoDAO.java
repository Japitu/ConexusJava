package br.com.fiap.dao;

import br.com.fiap.to.ChamadoTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ChamadoDAO {

    public ArrayList<ChamadoTO> findAll() {
        ArrayList<ChamadoTO> chamados = new ArrayList<ChamadoTO>();
        String sql = "select * from t_cxv_chamado order by id_chamado";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ChamadoTO chamado = new ChamadoTO();
                    chamado.setId(rs.getLong("id_chamado"));
                    chamado.setTipoProblema(rs.getString("tp_problema"));
                    chamado.setUrgencia(rs.getInt("nr_urgencia"));
                    chamado.setStatus(rs.getString("st_dificuldade"));
                    chamado.setDataChamado(rs.getDate("dt_chamado").toLocalDate()); //Ver com o pessoal
                    chamado.setIdDificuldade(rs.getLong("id_dificuldade"));
                    chamado.setIdPaciente(rs.getLong("id_paciente"));
                    chamados.add(chamado);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return chamados;
    }

    public ChamadoTO save(ChamadoTO chamado) {
        String sql = "insert into t_cxv_chamado(tp_problema, nr_urgencia, st_dificuldade, dt_chamado, id_dificuldade, id_paciente) values (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, chamado.getTipoProblema());
            ps.setInt(2, chamado.getUrgencia());
            ps.setString(3, chamado.getStatus()); //Isso vai começar com "Agendado"?
            ps.setDate(4, Date.valueOf(LocalDate.now()));
            ps.setLong(5, chamado.getIdDificuldade());
            ps.setLong(6, chamado.getIdPaciente());
            if (ps.executeUpdate() > 0) {
                return chamado;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public ChamadoTO findById (Long id) {
        ChamadoTO chamado = new ChamadoTO();
        String sql = "select * from t_cxv_chamado where id_chamado = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                chamado.setId(rs.getLong("id_chamado"));
                chamado.setTipoProblema(rs.getString("tp_problema"));
                chamado.setUrgencia(rs.getInt("nr_urgencia"));
                chamado.setStatus(rs.getString("st_dificuldade"));
                chamado.setDataChamado(rs.getDate("dt_chamado").toLocalDate());
                chamado.setIdDificuldade(rs.getLong("id_dificuldade"));
                chamado.setIdPaciente(rs.getLong("id_paciente"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return chamado;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_cxv_chamado where id_chamado = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao excluir: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return false;
    }

    public ChamadoTO update(ChamadoTO chamado) {
        String sql = "update t_cxv_chamado set tp_problema = ?, nr_urgencia = ?, st_dificuldade = ?, id_dificuldade = ?, id_paciente = ? where id_chamado = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, chamado.getTipoProblema());
            ps.setInt(2, chamado.getUrgencia());
            ps.setString(3, chamado.getStatus());
            ps.setLong(4, chamado.getIdDificuldade());
            ps.setLong(5, chamado.getIdPaciente());
            ps.setLong(6, chamado.getId());
            if (ps.executeUpdate() > 0) {
                return chamado;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

}
