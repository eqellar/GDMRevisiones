/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.FuncionalidadDAO;
import dto.FuncionalidadDTO;
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
public class ActualizarFuncionalidad extends HttpServlet {

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
        
        String funcionalidad = request.getParameter("txtFuncionalidad");
        String nuevafuncionalidad = request.getParameter("txtnewFuncionalidad");
        String nuevonombrecorto = request.getParameter("txtnewNombrecorto");
        FuncionalidadDAO fun = new FuncionalidadDAO();
        ArrayList<FuncionalidadDTO> listfun = fun.readAll();
        int id_funcion = 0;
        
        for(int i = 0; i<listfun.size(); i++){
            if(listfun.get(i).getTipo().equals(funcionalidad)){
                               
                id_funcion = listfun.get(i).getId_funcion();
                System.out.println(id_funcion+" El id es: " + funcionalidad);                
            }
            
        }
        
        if(funcionalidad.equals("") || nuevonombrecorto.equals("") || nuevafuncionalidad.equals("")){
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        if(nuevonombrecorto != "" && nuevafuncionalidad != ""){
           boolean verifica = fun.update(new FuncionalidadDTO(id_funcion, nuevafuncionalidad, nuevonombrecorto));
           if(verifica == true){
                String exito ="Registro Exitoso!!!";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exito.jsp").forward(request, response);
            }
            else{
            String error = "No fue posible realizar el registro...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            
            System.out.println(funcionalidad+id_funcion+nuevafuncionalidad+nuevonombrecorto);
                
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
