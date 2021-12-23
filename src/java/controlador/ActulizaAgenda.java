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
public class ActulizaAgenda extends HttpServlet {

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
        
        String idsolicitud = request.getParameter("id_solicitud");
        int id_solicitud = Integer.parseInt(idsolicitud);
        int id_dsipositivo =0;
        int id_cliente =0;
        int id_vehiculo =0;
        int id_usuario =0;
        String fechasol = "";
        String motivo  = "";
        String status = "Agendada";
        String folio = "";
        
        String lugar =request.getParameter("lugar");
        
        String instalador =request.getParameter("tecname");
        String contacto = request.getParameter("contact");
        int estado =0;
        
        String annioagenda = request.getParameter("annioagenda");
        String mesagenda = request.getParameter("mesagenda");
        String diaagenda = request.getParameter("diaagenda");
        String horaagenda = request.getParameter("horaagenda");
        String minagenda = request.getParameter("minagenda");
        
        String cero = "0";
        
        if(mesagenda.length() == 1){
            mesagenda = cero+mesagenda;
        }
        if(diaagenda.length() == 1){
            diaagenda = cero+diaagenda;
        }
        if(horaagenda.length() == 1){
            horaagenda = cero+horaagenda;
        }
        if(minagenda.length() == 1){
            minagenda = cero+minagenda;
        }
         String fec_agenda= annioagenda+"-"+mesagenda+"-"+diaagenda;
         String hora= horaagenda+":"+minagenda+":00";
        
        if(status.equals("Pendiente") ){
            estado =1;
        }
        if(status.equals("Agendada") ){
            estado =2;
        }
        if(status.equals("Atendida") ){
            estado =3;
        }
        if(status.equals("Cancelada") ){
            estado =4;
        }
        
        if(idsolicitud != null){
            SolicitudDAO sol = new SolicitudDAO();
            SolicitudDTO solicitud = sol.read(idsolicitud);
            id_dsipositivo = solicitud.getId_dsipositivo();
            id_cliente = solicitud.getId_cliente();
            id_vehiculo = solicitud.getId_vehiculo();
            id_usuario = solicitud.getId_usuario();
            fechasol = solicitud.getFec_solicitud();
            motivo = solicitud.getMotivo();            
            folio = solicitud.getFolio();
            
            //boolean verifica = false;
            boolean verifica = sol.update(new SolicitudDTO(id_solicitud, id_dsipositivo, id_cliente, id_vehiculo, id_usuario, fechasol, motivo, estado, folio, fec_agenda, lugar, hora, instalador, contacto));
            if (verifica) {
                String exito = "La actualización se realizo exitosamente";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exitoLogistica.jsp").forward(request, response);
            }
            else{
                //System.out.println("Este es el valor de idsolicitud: " +id_solicitud);
                //System.out.println("Este es el valor de idcliente: " +id_cliente);
                //System.out.println("Este es el valor de iddispositivo: " +id_dsipositivo);
                //System.out.println("Este es el valor de idvehiculo: " +id_vehiculo);
                //System.out.println("Este es el valor de idusuario: " +id_usuario);
                
                String error = "No fue posible realizar la actualización";
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
