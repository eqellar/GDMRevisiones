/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.VehiculoDAO;
import dto.VehiculoDTO;
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
public class ActualizaVehiculo extends HttpServlet {

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

        String placas = request.getParameter("busplaca");
        String btnactuvehi = request.getParameter("btnactuvehi");
        String btnbusplac = request.getParameter("btnbusplac");
        String error = "";
        int idvehiculo = 0;
        int idcliente = 0;

        if (btnbusplac != null) {

            if (placas.equals("")) {
                error = "Ingresa una placa para la busqueda";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            } else {
                VehiculoDAO vehi = new VehiculoDAO();
                List<VehiculoDTO> listvehi = vehi.readAll();
                boolean bandera = false;

                for (int i = 0; i < listvehi.size(); i++) {
                    if (listvehi.get(i).getPlacas().equals(placas)) {
                        idvehiculo = listvehi.get(i).getId_vehiculo();
                        idcliente = listvehi.get(i).getId_cliente();
                        System.out.println("Si existen la placas: " + placas + "Este es el id del vehículo" + idvehiculo);
                        bandera = true;
                        VehiculoDTO datoVehiculo = vehi.read(idvehiculo);
                        String marca = datoVehiculo.getMarca();
                        String sub_marca = datoVehiculo.getSubmarca();
                        String modelo = datoVehiculo.getModelo();
                        String color = datoVehiculo.getColor();
                        String economico = datoVehiculo.getEconomico();
                        String placa = datoVehiculo.getPlacas();
                        request.getSession().setAttribute("marca", marca);
                        request.getSession().setAttribute("sub_marca", sub_marca);
                        request.getSession().setAttribute("modelo", modelo);
                        request.getSession().setAttribute("color", color);
                        request.getSession().setAttribute("economico", economico);
                        request.getSession().setAttribute("placas", placas);
                        //System.out.println("Datos del cliente"+imei+", "+tipo+", "+vendedor); //Prueba de impresión para verificar los valores capturados  

                        request.getRequestDispatcher("actualizarVehiculo.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.
                    }
                }
                if (bandera == false) {
                    error = "la placa que ingreso no existe, por favor vuelva a intentar";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            }
        }

        if (btnactuvehi != null) {
            VehiculoDAO vehi = new VehiculoDAO();
            List<VehiculoDTO> listvehi = vehi.readAll();
            String matricula = request.getParameter("matricula");
            String placa = request.getParameter("placa");
            String marca = request.getParameter("marca");
            String sumarca = request.getParameter("submarca");
            String modelo = request.getParameter("modelo");
            String color = request.getParameter("color");
            String eco = request.getParameter("eco");
            
            
            for (int i = 0; i < listvehi.size(); i++) {
                
                if (listvehi.get(i).getPlacas().equals(matricula)) {
                        idvehiculo = listvehi.get(i).getId_vehiculo();
                        idcliente = listvehi.get(i).getId_cliente();
                        System.out.println("Este es el id de vehiculo: " + idvehiculo + "Este es el ID del Cliente: " + idcliente);
                        boolean verifica = vehi.update(new VehiculoDTO(idvehiculo, idcliente, marca, sumarca, modelo, color, eco, placa));
                        if(verifica == false){
                            error = "No fue posible realizar la actualización";
                            request.getSession().setAttribute("error", error);
                            request.getRequestDispatcher("error.jsp").forward(request, response);
                            
                        }else{
                            String exito = "La actualización se realizo exitosamente";
                            request.getSession().setAttribute("exito", exito);
                            request.getRequestDispatcher("exito.jsp").forward(request, response);
                            
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
