/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AplicaDAO;
import dao.ClienteDAO;
import dao.DispositivoDAO;
import dao.FuncionalidadDAO;
import dao.VehiculoDAO;
import dto.AplicaDTO;
import dto.ClienteDTO;
import dto.DispositivoDTO;
import dto.FuncionalidadDTO;
import dto.VehiculoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class RegDisp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings("StringEquality")
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        ClienteDAO clie = new ClienteDAO();
        ArrayList<ClienteDTO> listclie = clie.readAll();
        VehiculoDAO vehi = new VehiculoDAO();
        ArrayList<VehiculoDTO> listvehi = vehi.readAll();
        String imei = request.getParameter("txtIMEI");
        String tipo = request.getParameter("txtTipoDispositivo");
        String telefono = request.getParameter("txtTelefono");
        String numsim = request.getParameter("txtNumSim");
        String clientes = request.getParameter("txtClientes");
        String vehiculos = request.getParameter("txtVehiculos");
        
        String ubicacion = request.getParameter("txtUbicacion");
        
        String tiposerv = request.getParameter("txtTipoServ");
        
        String annioinst = request.getParameter("annioinst");
        String mesinst = request.getParameter("mesinst");
        String diainst = request.getParameter("diainst");

        
        String cero = "0";
        
        if(mesinst.length() == 1){
            mesinst = cero+mesinst;
        }
        if(diainst.length() == 1){
            diainst = cero+diainst;
        }
        
        
         String fechinstala= annioinst+"-"+mesinst+"-"+diainst;
         
         String annioserv = request.getParameter("annioserv");
        String messerv  = request.getParameter("messerv");
        String diaserv  = request.getParameter("diaserv");
    
        
  
        
        if(messerv.length() == 1){
            messerv = cero+messerv;
        }
        if(diaserv.length() == 1){
            diaserv = cero+diaserv;
        }
        
        
        
         String fechultserv= annioserv+"-"+messerv+"-"+diaserv;
        
         System.out.println("Este es el id del cliente: " +clientes+",vehiculo: "+vehiculos);
       
        int idcliente = 0;
        int idvehiculo = 0;
        /*System.out.println("Esto es lo que hay en placas : " +vehiculos);
        for (int i = 0; i < listvehi.size(); i++) {
            System.out.println("Lista de placas: "+listvehi.get(i).getPlacas());
            if (listvehi.get(i).getPlacas().equals(vehiculos)) {
                idvehiculo = listvehi.get(i).getId_vehiculo();
               System.out.println("Este es el di del vehículo: "+ idvehiculo);
                
               
            }
            else{
                //System.out.println("No se está haciendo por esto: : " +idvehiculo);
                
            }                
        }*/
         
                

        if (imei.equals("") || telefono.equals("") || numsim.equals("") || vehiculos.equals("")) {
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        if (imei != "" && tipo != "" && telefono != "" && numsim != "" && clientes != "") {
            idcliente = Integer.parseInt(clientes);
            idvehiculo = Integer.parseInt(vehiculos);
            DispositivoDAO dis = new DispositivoDAO();
            boolean verifica = dis.create(new DispositivoDTO(0, idcliente, idvehiculo, imei, tipo, telefono, numsim, fechinstala, ubicacion, fechultserv, tiposerv));

            if (verifica == true) {
                String exito = "Registro Exitoso!!!";
                request.getSession().setAttribute("exito", exito);
                request.getSession().setAttribute("imei", imei);
                request.getRequestDispatcher("exitodisp.jsp").forward(request, response);
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
