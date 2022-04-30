/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopaciente.dao;
import br.com.projetopaciente.model.TipoSanguineo;
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
public class TipoSanguineoDAOImpl implements GenericDAO{

    
    private Connection conn;

     public TipoSanguineoDAOImpl() throws Exception {
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
        List<Object> tiposanguineos = new ArrayList();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select idtiposanguineo, tiposanguineo from tiposanguineo";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoSanguineo tipoSanguineo = new TipoSanguineo();                
                
                tipoSanguineo.setIdTipoSanguineo(rs.getInt("idtiposanguineo"));
                tipoSanguineo.setTipoSanguineo(rs.getString("tiposanguineo"));                
                
                tiposanguineos.add(tipoSanguineo);

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
        return tiposanguineos;
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
