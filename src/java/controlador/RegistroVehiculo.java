/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.VehiculoDAO;
import dto.ClienteDTO;
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
public class RegistroVehiculo extends HttpServlet {

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

        String marca = request.getParameter("txtMarca");
        String submarca = request.getParameter("txtSubmarca");
        String modelo = request.getParameter("txtModelo");
        String color = request.getParameter("txtColor");
        String eco = request.getParameter("txtEco");
        String placas = request.getParameter("txtPlacas");
        String clientes = request.getParameter("txtClientes");
        int idcliente =0;
        int existeplaca = 2;
        VehiculoDAO ve = new VehiculoDAO();
        
        

        

        if (marca.equals("") || submarca.equals("") || modelo.equals("") || color.equals("") || eco.equals("") || placas.equals("")) {
            String error = "Registro incorrecto: No puede haber campos vacios...";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }

        if (marca != "" &&submarca != "" && modelo != "" && color != "" && eco != "" && placas != "") {
            ArrayList<VehiculoDTO> listve = ve.readAll();
            for (int i = 0; i < listve.size(); i++) {//bucle para validad si exsite o no el usuario
                if (placas.equals(listve.get(i).getPlacas())) {
                    existeplaca = 1;
                    String error = "La placa del vehículo ya existe favor de elegir otra";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                    break;
                } else {
                    existeplaca = 0;
                }
            }
        }
            
            
            if(existeplaca == 0){
            
            
            idcliente = Integer.parseInt(clientes);
            
            boolean verifica = ve.create(new VehiculoDTO(0,idcliente, marca, submarca, modelo, color, eco, placas));
            
            if(verifica == true){
                String exito ="Registro Exitoso!!!";
                request.getSession().setAttribute("exito", exito);
                request.getRequestDispatcher("exito.jsp").forward(request, response);
            }
            else{
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
