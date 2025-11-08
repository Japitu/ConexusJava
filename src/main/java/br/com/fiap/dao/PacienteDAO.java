package br.com.fiap.dao;

import br.com.fiap.to.PacienteTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO {

    public ArrayList<PacienteTO> findAll() {
        ArrayList<PacienteTO> pacientes = new ArrayList<PacienteTO>();
        String sql = "select * from t_cxv_paciente order by id_paciente";
        try ( PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if ( rs != null) {
                while (rs.next()) {
                    PacienteTO paciente = new PacienteTO();
                    paciente.setId(rs.getLong("id_paciente"));
                    paciente.setNome(rs.getString("nm_paciente"));
                    paciente.setIdade(rs.getInt("nr_idade"));
                    paciente.setCpf(rs.getLong("nr_cpf"));
                    paciente.setSexoBiologico(rs.getString("fl_sexo_biologico"));
                    pacientes.add(paciente);
                }
            } else{
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
    return pacientes;
    }

    public PacienteTO save (PacienteTO paciente) {
        String sql = "insert into t_cxv_paciente (nm_paciente, nr_idade, nr_cpf, fl_sexo_biologico) values (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getIdade());
            ps.setLong(3, paciente.getCpf());
            ps.setString(4, paciente.getSexoBiologico());
            if (ps.executeUpdate() > 0) {
                return paciente;
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

    public PacienteTO findbyId(Long id) {
        PacienteTO paciente = new PacienteTO();
        String sql = "select * from t_cxv_paciente where id_paciente = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                paciente.setId(rs.getLong("id_paciente"));
                paciente.setNome(rs.getString("nm_paciente"));
                paciente.setIdade(rs.getInt("nr_idade"));
                paciente.setCpf(rs.getLong("nr_cpf"));
                paciente.setSexoBiologico(rs.getString("fl_sexo_biologico"));
            } else {
                return null;
            }
        }catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return paciente;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_cxv_paciente where id_paciente = ?";
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

    public PacienteTO update(PacienteTO paciente) {
        String sql = "update t_cxv_paciente set nm_paciente = ?, nr_idade = ?, nr_cpf = ?, fl_sexo_biologico = ? where id_paciente = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, paciente.getNome());
            ps.setInt(2, paciente.getIdade());
            ps.setLong(3, paciente.getCpf());
            ps.setString(4, paciente.getSexoBiologico());
            ps.setLong(5, paciente.getId());

        }catch (SQLException e) {
            System.out.println("Erro ao atualizar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
