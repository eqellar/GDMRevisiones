/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DispositivoDAO;
import dao.SolicitudDAO;
import dto.DispositivoDTO;
import dto.SolicitudDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class Busimei extends HttpServlet {

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
        
        String imei = request.getParameter("txtImei");
        DispositivoDAO dis = new DispositivoDAO();
        List<DispositivoDTO> listdis = dis.readAll();
        SolicitudDAO sol = new SolicitudDAO();
        List<SolicitudDTO> listsol = sol.readAll();
        String error ="";
        int bandera =0;
        int iddispositivo =0;
        int idsolicitud =0;
        
        
         if (imei.equals("")) {
            
            error = "El dispositivo no existe por favor verifique los datos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }else{
             System.out.println("Esto esta en IMEI: "+imei);
             
             
             for (int j = 0; j < listdis.size(); j++) {
                if (imei.equals(listdis.get(j).getImei())) {
                    iddispositivo = listdis.get(j).getId_dsipositivo();
                    bandera = 1;
                }

            }
            if (bandera == 0) {
                error = "El dispositivo no existe por favor verifique los datos";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            }else{
            for (int a = 0; a < listsol.size(); a++) {
                if (iddispositivo == listsol.get(a).getId_dsipositivo()) {
                    idsolicitud = listsol.get(a).getId_solicitud();
                    //System.out.println("Este es el ID de la solicitud: "+idsolicitud);
                }
            }
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
