/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.SolicitudDAO;
import dto.SolicitudDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class Revision extends HttpServlet {

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
        
        String folio = request.getParameter("folio");
        String cliente = request.getParameter("txtClientes");
        String placas = request.getParameter("revplacas");
        String imei = request.getParameter("revimei");
        String motivo = request.getParameter("revcomen");
        
        String idusuario = request.getParameter("idusuario");
        
        int id_solicitud =0;
        int id_dsipositivo=0;
        int id_cliente =0;
        int id_vehiculo =0;
        int id_usuario =Integer.parseInt(idusuario);
        int estatus = 1;
        
        String annio = request.getParameter("annio");
        String mes = request.getParameter("mes");
        String dia = request.getParameter("dia");
        String hora = request.getParameter("hora");
        String min = request.getParameter("min");
        
        String cero = "0";
        
        if(mes.length() == 1){
            mes = cero+mes;
        }
        if(dia.length() == 1){
            dia = cero+dia;
        }
        if(hora.length() == 1){
            hora = cero+hora;
        }
        if(min.length() == 1){
            min = cero+min;
        }
         String fec_solicitud= annio+"-"+mes+"-"+dia+" "+hora+":"+min+":00";
        
        SolicitudDAO sol = new SolicitudDAO();
                
        
        System.out.println(folio+cliente+placas+imei+motivo);
        
        if(folio.equals("") || cliente.equals("") || placas.equals("") || imei.equals("") || motivo.equals("")){
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }else{
            
            id_dsipositivo = Integer.parseInt(imei);
            id_cliente = Integer.parseInt(cliente);
            id_vehiculo = Integer.parseInt(placas);
            boolean verifica = sol.create(new SolicitudDTO(id_solicitud, id_dsipositivo, id_cliente, id_vehiculo, id_usuario, fec_solicitud, motivo, estatus, folio,null, null, null, null, null));
             if(verifica){
                 String exito = "Registro Exitoso!!!";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exito.jsp").forward(request, response);
             }else{
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
