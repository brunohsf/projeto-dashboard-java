package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Cadastro;
import br.com.projetopaciente.model.Endereco;
import br.com.projetopaciente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CadastroDAOImpl implements GenericDAO {

    private Connection conn;

    public CadastroDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public Integer cadastrar(Cadastro cadastro, Endereco endereco) throws Exception {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Integer idCadastro = null;

        String sql = "insert into cadastro(nome, idendereco) values (?, ?) returning idcadastro;";

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cadastro.getNome());
            stmt.setInt(2, new EnderecoDAOImpl().cadastrar(endereco));            
            rs = stmt.executeQuery();
            if (rs.next()) {
                idCadastro = rs.getInt("idcadastro");
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao cadastrar Cadastro! Erro: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt, rs);
            } catch (Exception ex) {
                System.out.println("Problemas ao fechar os parâmetros de conexão! Erro: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        return idCadastro;
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
