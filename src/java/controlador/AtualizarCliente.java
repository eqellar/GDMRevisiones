/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dto.ClienteDTO;
import dto.DispositivoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class AtualizarCliente extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
        
        ClienteDAO clie = new ClienteDAO();
        ArrayList<ClienteDTO> listclie = clie.readAll();
        
        String nombre_clie = request.getParameter("txtNuevoNombre");
        String alias = request.getParameter("txtNuevoAlias");        
        String vendedor = request.getParameter("txtNuevoVendedor");
        String idcliente = request.getParameter("resultado");
        
        
        for(int i = 0; i < listclie.size(); i++){
            System.out.println("Esto es lo que hay en ID; "+idcliente);
            
        }
        
        if (nombre_clie.equals("") || alias.equals("") || vendedor.equals("")) {
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        if (nombre_clie != "" && alias != "" && vendedor != "") {
            int id_cliente =  Integer.parseInt(idcliente);            
            boolean verifica = clie.update(new ClienteDTO(id_cliente, nombre_clie, alias, vendedor));

            if (verifica == true) {
                String exito = "Registro Exitoso!!!";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exito.jsp").forward(request, response);
            } else {
                String error = "No fue posible realizar el registro...";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);

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
