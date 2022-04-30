
package br.com.projetopaciente.controller;

import br.com.projetopaciente.dao.GenericDAO;
import br.com.projetopaciente.dao.TipoSanguineoDAOImpl;
import br.com.projetopaciente.dao.UfDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ListarCombos", urlPatterns = {"/ListarCombos"})
public class ListarCombos extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            try {
                
                GenericDAO daoTipoSanguineo = new TipoSanguineoDAOImpl();
                request.setAttribute("tiposanguineos", daoTipoSanguineo.listar());
                System.out.println("Setou tipo sanguineo");
                GenericDAO daoUF = new UfDAOImpl();
                request.setAttribute("ufs", daoUF.listar());
                System.out.println("Setou uf");
                
                request.getRequestDispatcher("cadastrarpaciente.jsp").forward(request, response);
                System.out.println("Enviou para JSP");

            } catch (Exception e) {
                System.out.println("Problemas ao listar combos!> Erro: " + e.getMessage());
            }
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
