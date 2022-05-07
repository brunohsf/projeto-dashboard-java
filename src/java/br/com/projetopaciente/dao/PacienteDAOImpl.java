/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Paciente;
import br.com.projetopaciente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class PacienteDAOImpl implements GenericDAO {

    private Connection conn;

     public PacienteDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    
    @Override
    public Boolean cadastrar(Object object) {

        Paciente paciente = (Paciente) object;
        PreparedStatement stmt = null;

        String sql = "insert into paciente (idcadastro, idtiposanguineo, peso) values (?,?,?);";

        try {
            stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, new CadastroDAOImpl().cadastrar(paciente, paciente.getEndereco()));
            stmt.setInt(2, paciente.getTipoSanguineo());
            stmt.setDouble(3, paciente.getPeso());
            stmt.execute();

            return true;

        } catch (Exception e) {
            System.out.println("Problemas ao cadatrar paciente! Erro: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }

        }
    }

    @Override
    public List<Object> listar() {
        
        List<Object> pacientes = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select id, nome, endereco, cidade, uf, cep from paciente";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                paciente.setEndereco(rs.getString("endereco"));
                paciente.setCidade(rs.getString("cidade"));
                paciente.setUf(rs.getString("uf"));
                paciente.setCep(rs.getString("cep"));
                pacientes.add(paciente);

            }

        } catch (Exception e) {
            System.out.println("Problemas ao listar paciente! Erro: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }

        }
        return pacientes;
        
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
