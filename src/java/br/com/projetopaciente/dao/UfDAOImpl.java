
package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Uf;
import br.com.projetopaciente.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UfDAOImpl implements GenericDAO {
   

     private Connection conn;

     public UfDAOImpl() throws Exception {
        try {
            this.conn = ConnectionFactory.getConnection();
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
    

    @Override
    public Boolean cadastrar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> listar() {
        
        List<Object> ufs = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select iduf, uf from uf order by uf";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Uf uf = new Uf();                
                uf.setIdUf(rs.getInt("iduf"));
                uf.setUf(rs.getString("uf"));
                
                ufs.add(uf);

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
        return ufs;
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
