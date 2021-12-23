/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
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
public class ActualizaUsuario extends HttpServlet {

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

        UsuarioDAO usu = new UsuarioDAO();
        ArrayList<UsuarioDTO> listusu = usu.readAll();
        String nombre = request.getParameter("txtname");
        String apellidos = request.getParameter("txtNuevoApellido");
        String nivel = request.getParameter("txtNuevoNivel");
        String password = request.getParameter("txtNuevoPassword");
        String usuario = request.getParameter("txtNuevoUsuario");
        String username = request.getParameter("usu");
        String error = "";

        int id_usuario = 0;

        System.out.println("Nombre: "+nombre + " Apellido: "+ apellidos + " Nivel: "+nivel + " Pssw:"+password + " User: "+usuario);

        for (int i = 0; i < listusu.size(); i++) {
            if (username.equals(listusu.get(i).getUsuario())) {
                id_usuario = listusu.get(i).getId_usuario();
            }
        }

        System.out.println(id_usuario);

        if (usuario.equals("") || nombre.equals("") || apellidos.equals("") || nivel.equals("") || password.equals("")) {
            error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        } else {
            int tipo = Integer.parseInt(nivel);
            boolean verifica = usu.update(new UsuarioDTO(id_usuario, nombre, apellidos, tipo, usuario, password));

            if (verifica) {
                String exito = "La actualización se realizo exitosamente";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exito.jsp").forward(request, response);
            }
            else{
                error = "No fue posible realizar la actualización";
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
