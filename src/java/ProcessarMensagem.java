/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Lucas
 */
@WebServlet(urlPatterns = {"/ProcessarMensagem"})
public class ProcessarMensagem extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nomePaciente = request.getParameter("nomePaciente");
        String nomeMedico = request.getParameter("nomeMedico");
        String enderecoPaciente = request.getParameter("enderecoPaciente");
        String cidadePaciente = request.getParameter("cidadePaciente");
        String doencaRelatada = request.getParameter("doencaRelatada");

        int numeroDias = 0;
        switch (doencaRelatada) {
            case "febre":
                numeroDias = 2;
                break;
            case "dorCorpo":
                numeroDias = 1;
                break;
            case "tontura":
                numeroDias = 3;
                break;
            case "pernaQuebrada":
                numeroDias = 60;
                break;
            case "dorColuna":
                numeroDias = 5;
                break;
        }
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter Formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = dataAtual.format(Formatador);

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Atestado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>LOGO</h1>");
            out.println("<div>");
            out.println("<p>");
            out.println("<h2>ATESTADO</h2><br>");
            out.println("Atesto para devido fins que ");
            out.println(nomePaciente);
            out.println(", residente e domiciliado(a) à ");
            out.println(enderecoPaciente);
            out.println("não se encontra em condições de trabalho por");
            out.println(numeroDias);
            out.println(" dia(s) <br><br>");
            out.println(cidadePaciente);
            out.println(" - ");
            out.println(dataFormatada);
            out.println("<br><br>");
            out.println("_______________________________________<br><br>");
            out.println(nomeMedico);
            out.println("</html>");
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
