/*


Este é um servlet Java que faz parte de um aplicativo web de cadastro de imóveis. O servlet é responsável
por listar todos os imóveis cadastrados no banco de dados.

O método doGet() é chamado quando o servlet recebe uma requisição HTTP GET. O método chama o método
processRequest() para processar a requisição.

O método processRequest() usa um objeto GenericDAO e um objeto ImovelDAO para buscar todos os registros de
imóveis no banco de dados. Os registros são armazenados em um atributo chamado "Imovel" e enviados para a
página JSP "/cadastros/imovel/imovel.jsp" para serem exibidos em uma tabela HTML.

O método doPost() é chamado quando o servlet recebe uma requisição HTTP POST. O método também chama o
método processRequest() para processar a requisição.

O método getServletInfo() retorna uma breve descrição do servlet.



 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.curso.controller.imovel;

import br.com.curso.dao.GenericDAO;
import br.com.curso.dao.ImovelDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HOME
 */
@WebServlet(name = "ImovelListar", urlPatterns = {"/ImovelListar"})
public class ImovelListar extends HttpServlet {

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
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            GenericDAO dao = new ImovelDAO();
            request.setAttribute("imoveis", dao.listar());
            request.getRequestDispatcher("/cadastros/imovel/imovel.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao listar Imovel! Erro: " + ex.getMessage());
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
