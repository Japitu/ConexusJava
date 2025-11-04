package br.com.fiap.dao;

import br.com.fiap.to.DificuldadeTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DificuldadeDAO {

    public ArrayList<DificuldadeTO> findAll() {
        ArrayList<DificuldadeTO> dificuldades = new ArrayList<DificuldadeTO>();
        String sql = "select * from t_cxv_dificuldade order by id_dificuldade";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if ( rs != null) {
                while (rs.next()) {
                    DificuldadeTO dificuldade = new DificuldadeTO();
                    dificuldade.setId(rs.getLong("id_dificuldade"));
                    dificuldade.setIdPaciente(rs.getLong("id_paciente"));
                    dificuldade.setStatus(rs.getString("st_dificuldade"));
                    dificuldade.setDataDificuldade(rs.getDate("dt_dificuldade").toLocalDate());
                    dificuldade.setDescricao(rs.getString("dc_dificuldade"));
                    dificuldades.add(dificuldade);
                }
            } else {
                return null;
            }
        }catch (SQLException e) {
            System.out.println("Erro na consulta: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return dificuldades;
    }

    public DificuldadeTO save (DificuldadeTO dificuldade) {
        String sql = "insert into t_cxv_dificuldade (id_paciente, st_dificuldade, dt_dificuldade, dc_dificuldade) values (?, ?, ?, ?)";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, dificuldade.getIdPaciente());
            ps.setString(2, dificuldade.getStatus());
            ps.setDate(3, Date.valueOf(dificuldade.getDataDificuldade()));
            ps.setString(4, dificuldade.getDescricao());
            if (ps.executeUpdate() > 0) {
                return dificuldade;
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


    public DificuldadeTO findById (Long id) {
        DificuldadeTO dificuldade = new DificuldadeTO();
        String sql = "select * from t_cxv_dificuldade where id = ?";
        try (PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dificuldade.setId(rs.getLong("id_dificuldade"));
                dificuldade.setIdPaciente(rs.getLong("id_paciente"));
                dificuldade.setStatus(rs.getString("st_dificuldade"));
                dificuldade.setDataDificuldade(rs.getDate("dt_dificuldade").toLocalDate());
                dificuldade.setDescricao(rs.getString("dc_dificuldade"));
            } else {
                return null;
            }
        } catch (SQLException e){
            System.out.println("Erro ao buscar: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection();
        }
        return dificuldade;
    }

    public boolean delete (Long id) {
        String sql = "delete from t_cxv_dificuldade where id_dificuldade = ?";
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

    public DificuldadeTO update(DificuldadeTO dificuldade) {
        String sql = "update t_cxv_dificuldade set id_paciente = ?, st_dificuldade = ?, dt_dificuldade = ?, dc_dificuldade = ? where id_dificuldade = ?";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setLong(1, dificuldade.getIdPaciente());
            ps.setString(2, dificuldade.getStatus());
            ps.setDate(3, Date.valueOf(dificuldade.getDataDificuldade()));
            ps.setString(4, dificuldade.getDescricao());
            ps.setLong(5, dificuldade.getId());
            if (ps.executeUpdate() > 0) {
                return dificuldade;
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
