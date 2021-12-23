/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class Login extends HttpServlet {

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
        
        String usuario = request.getParameter("txtUsuario");
        String password = request.getParameter("txtPassword");
        String tipouser = "";
        String nombre = "";
        String nombreUsuario = "";
        String id_usuario ="";
        int idusuario =0;
        int tipo =0;
        

        String error = "";
        if (usuario.equals("") || password.equals("")) {
            error = "No puede haber campos vacíos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            UsuarioDAO usu = new UsuarioDAO();
            ArrayList<UsuarioDTO> usulist = usu.readAll();
            int bandera = 0;
            for (int i = 0; i < usulist.size(); i++) {

                if (usulist.get(i).getUsuario().equals(usuario) && usulist.get(i).getPassword().equals(password))
                {                   
                    idusuario = usulist.get(i).getId_usuario();
                    tipo = usulist.get(i).getTipo();
                    bandera = 1;
                }
            }
                    if (bandera >0 && tipo == 1){
                        
                        UsuarioDTO user = usu.read(idusuario);
                        String apellido = user.getApellidos();                        
                        tipouser = Integer.toString(tipo);
                        nombre = user.getNombre();
                        nombreUsuario = nombre+" "+apellido;
                        id_usuario = Integer.toString(idusuario);
                        request.getSession().setAttribute("nombreUsuario", nombreUsuario);
                        request.getSession().setAttribute("tipouser", tipouser);
                        request.getSession().setAttribute("id_usuario", id_usuario);
                        System.out.println("Tipo de usuario: "+tipouser);
                        request.getRequestDispatcher("sistema.jsp").forward(request, response);
                        
                        
                    }
                    
                    if (bandera > 0 && tipo == 2){
                        UsuarioDTO user = usu.read(idusuario);
                        String apellido = user.getApellidos();                        
                        tipouser = Integer.toString(tipo);
                        nombre = user.getNombre();
                        nombreUsuario = nombre+" "+apellido;
                        request.getSession().setAttribute("nombreUsuario", nombreUsuario);
                        request.getSession().setAttribute("tipouser", tipouser);
                        System.out.println("Tipo de usuario: "+tipouser);
                        request.getRequestDispatcher("consultas.jsp").forward(request, response);
                                                
                    }
                    
                    if (bandera > 0 && tipo == 3){
                        UsuarioDTO user = usu.read(idusuario);
                        String apellido = user.getApellidos();                        
                        tipouser = Integer.toString(tipo);
                        nombre = user.getNombre();
                        nombreUsuario = nombre+" "+apellido;
                        request.getSession().setAttribute("nombreUsuario", nombreUsuario);
                        request.getSession().setAttribute("tipouser", tipouser);
                        System.out.println("Tipo de usuario: "+tipouser+" Nombre Usuario: "+nombre);
                        request.getRequestDispatcher("logistica.jsp").forward(request, response);
                                             
                    }
                    
                    if (bandera == 0) {
                error = "El usuario no existe o la contraseña es incorrecta, por favor intente de nuevo";
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
