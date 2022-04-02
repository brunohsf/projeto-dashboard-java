package br.com.projetopaciente.controller;

import br.com.projetopaciente.dao.GenericDAO;
import br.com.projetopaciente.dao.PacienteDAOImpl;
import br.com.projetopaciente.model.Paciente;
import static com.oracle.wls.shaded.org.apache.xalan.xsltc.compiler.util.Type.Int;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarPaciente", urlPatterns = {"/CadastrarPaciente"})
public class CadastrarPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String nome = request.getParameter("nome");
        String endereco = request.getParameter("endereco");
        String tipoSanguineo = request.getParameter("tiposanguineo");
        Double peso = Double.parseDouble(request.getParameter("peso"));
        String cidade = request.getParameter("cidade");
        String uf = request.getParameter("uf");
        String cep = request.getParameter("cep");
        
        String mensagem = null;
        
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setEndereco(endereco);
        paciente.setTipoSanguineo(tipoSanguineo);
        paciente.setPeso(peso);
        paciente.setCidade(cidade);
        paciente.setUf(uf);
        paciente.setCep(cep);
        
        try {
            GenericDAO dao = new PacienteDAOImpl();
            if (dao.cadastrar(paciente)) {
                mensagem = "Paciente cadastrado com sucesso";
            } else {
                mensagem = "Problemas ao cadstrar paciente. Verifique os dados informados e tente novamente";
            }
            request.setAttribute("mensagem", mensagem);
            request.getRequestDispatcher("cadastrarpaciente.jsp").forward(request, response);
        } catch (Exception ex) {
            System.err.println("Problemas ao cadastrar produto erro na Servelet!Erro:" + ex.getMessage());
            ex.printStackTrace();
        }
        
        
        
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
