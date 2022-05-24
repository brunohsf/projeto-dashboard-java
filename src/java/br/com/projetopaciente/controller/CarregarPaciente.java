/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetopaciente.controller;

import br.com.projetopaciente.dao.GenericDAO;
import br.com.projetopaciente.dao.PacienteDAOImpl;
import br.com.projetopaciente.dao.TipoSanguineoDAOImpl;
import br.com.projetopaciente.dao.UfDAOImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BrunoHenrique
 */
@WebServlet(name = "CarregarPaciente", urlPatterns = {"/CarregarPaciente"})
public class CarregarPaciente extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            Integer idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

            GenericDAO daoTipoSanguineo = new TipoSanguineoDAOImpl();
            request.setAttribute("tiposanguineos", daoTipoSanguineo.listar());
            System.out.println("Setou tipo sanguineo");
            
            GenericDAO daoUF = new UfDAOImpl();
            request.setAttribute("ufs", daoUF.listar());
            System.out.println("Setou uf");
            
            GenericDAO daoPaciente = new PacienteDAOImpl();
            request.setAttribute("paciente", daoPaciente.carregar(idPaciente));
            System.out.println("Setou paciente");
            
            request.getRequestDispatcher("alterarpaciente.jsp").forward(request, response);
            
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarregarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CarregarPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
