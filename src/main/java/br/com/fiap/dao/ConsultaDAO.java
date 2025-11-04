package br.com.fiap.dao;

import br.com.fiap.to.ConsultaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDAO {

    public ArrayList<ConsultaTO> findAll() {
        ArrayList<ConsultaTO> consultas = new ArrayList<ConsultaTO>();
        String sql = "select * from t_cxv_consulta order by id_consulta";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ConsultaTO consulta = new ConsultaTO();
                    consulta.setId(rs.getLong("id_consulta"));
                    consulta.setStatus(rs.getString("st_consulta"));
                    consulta.setIdMedico(rs.getLong("id_medico"));
                    consulta.setIdPaciente(rs.getLong("id_paciente"));
                    consulta.setIdChamado(rs.getLong("id_chamado"));
                    consultas.add(consulta);
                }
            }
        }catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return consultas;
    }

    public ConsultaTO save(ConsultaTO consulta) {
        String sql = "insert into t_cxv_consulta(st_consulta, id_medico, id_paciente, id_chamado) values (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, consulta.getStatus());
            ps.setLong(2, consulta.getIdMedico());
            ps.setLong(3, consulta.getIdPaciente());
            ps.setLong(4, consulta.getIdChamado());
            if (ps.executeUpdate() > 0) {
                return consulta;
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

    public ConsultaTO findById (Long id) {
        ConsultaTO consulta = new ConsultaTO();
        String sql = "select * from t_cxv_consulta where id_consulta = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                consulta.setId(rs.getLong("id_consulta"));
                consulta.setStatus(rs.getString("st_consulta"));
                consulta.setIdMedico(rs.getLong("id_medico"));
                consulta.setIdPaciente(rs.getLong("id_paciente"));
                consulta.setIdChamado(rs.getLong("id_chamado"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return consulta;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_cxv_consulta where id_consulta = ?";
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

    public ConsultaTO update(ConsultaTO consulta) {
        String sql = "update t_cxv_consulta set st_consulta = ?, id_medico = ?, id_paciente = ?, id_chamado = ? where id_consulta = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, consulta.getStatus());
            ps.setLong(2, consulta.getIdMedico());
            ps.setLong(3, consulta.getIdPaciente());
            ps.setLong(4, consulta.getIdChamado());
            ps.setLong(5, consulta.getId());
            if(ps.executeUpdate() > 0) {
                return consulta;
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
