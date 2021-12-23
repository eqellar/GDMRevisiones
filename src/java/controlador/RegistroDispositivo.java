/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.DispositivoDAO;
import dao.VehiculoDAO;
import dto.ClienteDTO;
import dto.DispositivoDTO;
import dto.VehiculoDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Corei3
 */
public class RegistroDispositivo extends HttpServlet {

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
        
        VehiculoDAO vehi = new VehiculoDAO();
        ArrayList<VehiculoDTO> listvehi = vehi.readAll();
        
        DispositivoDAO dis = new DispositivoDAO();
        List<DispositivoDTO> listdis = dis.readAll();
        
        String imei = request.getParameter("txtIMEI");
        String tipo = request.getParameter("txtTipoDispositivo");
        String telefono = request.getParameter("txtTelefono");
        String numsim = request.getParameter("txtNumSim");
        String clientes = request.getParameter("txtClientes");
        String vehiculos = request.getParameter("txtVehiculos");
        int idcliente = 0;
        int idvehiculo = 0;
        int existedispositivo = 2;
        String id_cliente ="";
        
        System.out.println(idcliente+" El cliente es: " + clientes + vehiculos);
       
        
        for(int i = 0; i < listclie.size(); i++){
            if(listclie.get(i).getAlias().equals(clientes)){
            idcliente = listclie.get(i).getId_cliente();
            System.out.println(idcliente+" El cliente es: " + clientes);
            
            }
            
            id_cliente = Integer.toString(idcliente);
            
        }
        
        for(int i = 0; i < listvehi.size(); i++){
            if(listvehi.get(i).getPlacas().equals(vehiculos)){
            idvehiculo = listvehi.get(i).getId_vehiculo();
            System.out.println(idcliente+" Las placas son: " + vehiculos);
            
            
            }
            
            if (imei.equals("") || telefono.equals("") || numsim.equals("")) {
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
            
            if (imei != "" && tipo != "" && telefono != "" && numsim != "" && clientes != "") {
                
                for (int j = 0; j < listdis.size(); j++) {//bucle para validad si exsite o no el usuario
                if (imei.equals(listdis.get(j).getImei())) {
                    existedispositivo = 1;
                    String error = "El imei del dispositivo ya existe favor de elegir otro";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    break;
                } else {
                    existedispositivo = 0;
                }
            }
            }
                
               if(existedispositivo == 0){ 
                request.getSession().setAttribute("imei", imei);
                request.getSession().setAttribute("tipo", tipo);
                request.getSession().setAttribute("telefono", telefono);
                request.getSession().setAttribute("numsim", numsim);
                request.getSession().setAttribute("clientes", clientes);
                request.getSession().setAttribute("id_cliente", id_cliente);
                request.getRequestDispatcher("regDispositivo2.jsp").forward(request, response);
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
