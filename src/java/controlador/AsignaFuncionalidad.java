/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AplicaDAO;
import dao.DispositivoDAO;
import dao.FuncionalidadDAO;
import dto.AplicaDTO;
import dto.DispositivoDTO;
import dto.FuncionalidadDTO;
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
public class AsignaFuncionalidad extends HttpServlet {

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
        DispositivoDAO dis = new DispositivoDAO();
        List<DispositivoDTO> listdis = dis.readAll();
        String imei = request.getParameter("imei");
        int id_dispositivo = 0;
        
        for(int i =0; i<listdis.size(); i++){
            if(imei.equals(listdis.get(i).getImei())){
                id_dispositivo = listdis.get(i).getId_dsipositivo();
            }
        }
        
        
        FuncionalidadDAO fun = new FuncionalidadDAO();
        ArrayList<FuncionalidadDTO> listfun = fun.readAll();
        List<String> check = new LinkedList<>();
        String namecheck = "";
        AplicaDAO ap = new AplicaDAO();
        
        boolean verifica = false;
        for(int i=0;i<listfun.size(); i++){
            String itera = Integer.toString(i);
            namecheck = request.getParameter(itera);
            
            if(namecheck != null){
                check.add(itera);
            }
            
        }
        System.out.println("Tengo los checkbox:  "+check);
        
        for(int i =0; i<check.size();i++){
            int id_funcionalidad = Integer.parseInt(check.get(i));
           verifica = ap.create(new AplicaDTO(id_dispositivo, id_funcionalidad));
        }
        
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
