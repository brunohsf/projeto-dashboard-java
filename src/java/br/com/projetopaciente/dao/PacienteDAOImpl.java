/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Endereco;
import br.com.projetopaciente.model.Paciente;
import br.com.projetopaciente.model.TipoSanguineo;
import br.com.projetopaciente.model.Uf;
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
            stmt.setInt(2, paciente.getTipoSanguineo().getIdTipoSanguineo());
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

        String sql = "select p.idpaciente, c.nome, e.endereco, e.cidade,u.iduf, u.uf  from paciente as p inner join cadastro as c on p.idcadastro = c.idcadastro inner join endereco as e on c.idendereco = e.idendereco inner join uf as u on e.iduf = u.iduf";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idpaciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setEndereco(new Endereco(rs.getString("endereco"), rs.getString("cidade"), rs.getInt("iduf"), rs.getString("uf")));
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

        PreparedStatement stmt = null;
        String sql = "delete from paciente where idpaciente = ?;";
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idObject);
            stmt.executeUpdate();
            new CadastroDAOImpl().excluir(idObject);
            return true;
        } catch (Exception ex) {
            System.out.println("Problemas ao excluir o paciente! Erro" 
                    + ex.getMessage());
            ex.printStackTrace();
            return false;
        } finally {
            try {
                ConnectionFactory.closeConnection(conn, stmt);
            } catch (Exception e) {
                System.out.println("Problemas ao fechar a conexão! Erro: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object carregar(int idPaciente) {

        Paciente paciente = new Paciente();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.idpaciente, c.nome, p.peso, ts.idtiposanguineo, ts.tiposanguineo, e.endereco, e.cidade,u.iduf, u.uf, e.cep from paciente as p inner join cadastro as c on p.idcadastro = c.idcadastro inner join endereco as e on c.idendereco = e.idendereco inner join uf as u on e.iduf = u.iduf inner join tiposanguineo as ts on ts.idtiposanguineo = p.idtiposanguineo where p.idpaciente = ?";

        try {

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, idPaciente);

            rs = stmt.executeQuery();

            if (rs.next()) {

                paciente.setIdPaciente(rs.getInt("idpaciente"));
                paciente.setNome(rs.getString("nome"));
                paciente.setPeso(rs.getDouble("peso"));
                paciente.setTipoSanguineo(new TipoSanguineo(rs.getInt("idtiposanguineo"), rs.getString("tiposanguineo")));
                paciente.setEndereco(new Endereco(rs.getString("endereco"), rs.getString("cidade"),rs.getString("cep"), rs.getInt("iduf"), rs.getString("uf")));

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
        
        System.out.println(paciente.getEndereco().getCep());
        
        return paciente;
    }

    @Override
    public Boolean alterar(Object object
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
