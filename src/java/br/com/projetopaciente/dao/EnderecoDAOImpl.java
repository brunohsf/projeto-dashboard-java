package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Endereco;
import br.com.projetopaciente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnderecoDAOImpl implements GenericDAO {

    private Connection conn;

    public EnderecoDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Integer cadastrar(Endereco endereco) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idEndereco = null;

        String sql = "insert into endereco (endereco, cep, iduf, cidade) values (?, ?, ?, ?) returning idendereco;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, endereco.getEndereco());
            stmt.setString(2, endereco.getCep());
            stmt.setInt(3, endereco.getIdUf());
            stmt.setString(4, endereco.getCidade());
            rs = stmt.executeQuery();
            if (rs.next()) {
                idEndereco = rs.getInt("idendereco");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Endereço! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idEndereco;
        
    }

    @Override
    public List<Object> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean excluir(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object carregar(int idObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean alterar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
