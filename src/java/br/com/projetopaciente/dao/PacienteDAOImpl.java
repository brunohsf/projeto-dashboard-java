/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetopaciente.dao;

import br.com.projetopaciente.model.Endereco;
import br.com.projetopaciente.model.Paciente;
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
        List<Object> enderecos = new ArrayList();
        List<Object> ufs = new ArrayList();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select p.idpaciente, c.nome, e.endereco, e.cidade, u.uf  from paciente as p inner join cadastro as c on p.idcadastro = c.idcadastro inner join endereco as e on c.idendereco = e.idendereco inner join uf as u on e.iduf = u.iduf";

        try {

            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while (rs.next()) {

                Paciente paciente = new Paciente();
                Endereco endereco = new Endereco();
                Uf uf = new Uf();
                paciente.setIdPaciente(rs.getInt("id"));
                paciente.setNome(rs.getString("nome"));
                endereco.setEndereco(rs.getString("endereco"));
                endereco.setCidade(rs.getString("cidade"));
                uf.setUf(rs.getString("uf"));
                endereco.setCep(rs.getString("cep"));
                pacientes.add(paciente);
                enderecos.add(endereco);
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
