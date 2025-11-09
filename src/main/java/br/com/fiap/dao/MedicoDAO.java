package br.com.fiap.dao;

import br.com.fiap.to.MedicoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MedicoDAO {

    public ArrayList<MedicoTO> findAll() {
        ArrayList<MedicoTO> medicos = new ArrayList<MedicoTO>();
        String sql = "select * from t_cxv_medico order by id_medico";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql))
        {
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MedicoTO medico = new MedicoTO();
                    medico.setId(rs.getLong("id_medico"));
                    medico.setNome(rs.getString("nm_medico"));
                    medico.setArea(rs.getString("ar_medico"));
                    medico.setTelefone(rs.getLong("nr_tel"));
                    medicos.add(medico);
                }
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return medicos;
    }

    public MedicoTO save(MedicoTO medico){
        String sql = "insert into t_cxv_medico (nm_medico, ar_medico, nr_tel) values (?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getArea());
            ps.setLong(3, medico.getTelefone());
            if (ps.executeUpdate() > 0) {
                return medico;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

    public MedicoTO findById(Long id) {
        MedicoTO medico = new MedicoTO();
        String sql = "select * from t_cxv_medico where id_medico = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                medico.setId(rs.getLong("id_medico"));
                medico.setNome(rs.getString("nm_medico"));
                medico.setArea(rs.getString("ar_medico"));
                medico.setTelefone(rs.getLong("nr_tel"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return medico;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_cxv_medico where id_medico = ?";
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

    public MedicoTO update(MedicoTO medico) {
        String sql = "update t_cxv_medico set nm_medico = ?, ar_medico = ?, nr_tel = ? where id_medico = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getArea());
            ps.setLong(3, medico.getTelefone());
            ps.setLong(4, medico.getId());
            if (ps.executeUpdate() > 0) {
                return medico;
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }

}
