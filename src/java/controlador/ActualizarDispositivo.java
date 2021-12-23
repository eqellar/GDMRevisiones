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
import javax.servlet.http.HttpSession;

public class ActualizarDispositivo extends HttpServlet {

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
        String editar = request.getParameter("checkedit");
        boolean editando;
        String error = "";
        DispositivoDAO disp = new DispositivoDAO();
        
        ClienteDAO clie = new ClienteDAO();
        VehiculoDAO vehi = new VehiculoDAO();
        List<DispositivoDTO> listdisp = disp.readAll();
        List<ClienteDTO> listclie = clie.readAll();
        List<VehiculoDTO> listvehi = vehi.readAll();
        String imei = null;
        String cliente = null;
        String placas = null;
        String tipo = null;
        String telefono = null;
        String numSim = null;
        String fechinstala = null;
        String ubicacion = null;
        String fechultserv = null;
        String tiposerv = null;
        int id_dispositivo = 0;
        int id_cliente = 0;
        int id_vehiculo = 0;
        int bandera = 0;
        String dispID = null;
        
        String btnBuscar = request.getParameter("buscar");
        String btnActualizar = request.getParameter("actualiza");

        //System.out.println("Valores de los botones: " + "BTN1: "+btnBuscar+" BTN2: "+btnActualizar);

        if (btnBuscar != null) {
            String imeiObtenido = request.getParameter("buscaIMEI");
            if (imeiObtenido.equals("") || imeiObtenido.equals("0")) {
                //System.out.println("NO esta entrando...." + imeiObtenido);
                error = "El dispositivo que ingreso no existe";
                request.getSession().setAttribute("error", error);
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } else {

                //System.out.println("Esta entrando...." + imeiObtenido);
                for (int i = 0; i < listdisp.size(); i++) {
                    if (listdisp.get(i).getImei().equals(imeiObtenido)) {
                        id_dispositivo = listdisp.get(i).getId_dsipositivo();
                        bandera = 1;
                    }
                }

                    if (bandera > 0) {
                        DispositivoDTO iddis = disp.read(id_dispositivo);
                        
                        imei = iddis.getImei();
                        //cliente = listclie.get(i).getAlias();
                        //placas = listvehi.get(i).getPlacas();
                        tipo = iddis.getTipo();
                        telefono = iddis.getTelefono();
                        numSim = iddis.getNum_sim();
                        fechinstala = iddis.getFech_instala();
                        ubicacion = iddis.getUbicacion();
                        fechultserv = iddis.getFech_ult_serv();
                        tiposerv = iddis.getTipo_serv();

                        dispID = Integer.toString(id_dispositivo);
                        request.getSession().setAttribute("imei", imei);
                        request.getSession().setAttribute("cliente", cliente);
                        request.getSession().setAttribute("placas", placas);
                        request.getSession().setAttribute("tipo", tipo);
                        request.getSession().setAttribute("telefono", telefono);
                        request.getSession().setAttribute("numSim", numSim);
                        request.getSession().setAttribute("dispositivoID", dispID);
                        request.getSession().setAttribute("fechinstala", fechinstala);
                        request.getSession().setAttribute("ubicacion", ubicacion);
                        request.getSession().setAttribute("fechultserv", fechultserv);
                        request.getSession().setAttribute("tiposerv", tiposerv);

                        request.getRequestDispatcher("actualizarDispositivo.jsp").forward(request, response);

                    }

                
                if (bandera == 0) {
                    error = "El dispositivo no existe por favor verifique los datos";
                    request.getSession().setAttribute("error", error);
                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }

            }

        }
        
        if(btnActualizar !=null){
            //System.out.println("Estoy entrando a la actualización");
            imei = request.getParameter("txtimei");
            for (int i = 0; i < listdisp.size(); i++) {
                
                //System.out.println("Capturando IMEI: " + imei);
                if (listdisp.get(i).getImei().equals(imei)) {
                    id_dispositivo = listdisp.get(i).getId_dsipositivo();
                    //System.out.println("Esto hay en IMEI" +imei);
                    bandera = 1;                    
                    //System.out.println("Bandera = a: " +bandera);
                }
            }

                if (bandera > 0) {
                    
                    DispositivoDTO iddis = disp.read(id_dispositivo);
                    id_dispositivo = iddis.getId_dsipositivo();
                    id_cliente = iddis.getId_cliente();
                    id_vehiculo = iddis.getId_vehiculo();
                    
                    imei = request.getParameter("txtimei");
                    tipo = request.getParameter("txttipo");
                    telefono = request.getParameter("txttelefono");
                    numSim = request.getParameter("txtnumsim");
                    fechinstala = request.getParameter("txtfecinstala");
                    ubicacion = request.getParameter("txtubicacion");
                    fechultserv = request.getParameter("txtfechultserv");
                    tiposerv = request.getParameter("txttiposerv");
                    System.out.println("-"+id_dispositivo + "-"+id_cliente+"-"+id_vehiculo);
                    boolean verifica = disp.update(new DispositivoDTO(id_dispositivo, id_cliente, id_vehiculo, imei, tipo, telefono, numSim, fechinstala, ubicacion, fechultserv, tiposerv));

                    if (verifica == true) {
                        String exito = "La actualización se realizo exitosamente";
                        request.getSession().setAttribute("exito", exito);
                        request.getRequestDispatcher("exito.jsp").forward(request, response);

                    } else {
                        error = "No fue posible realizar la actualización";
                        request.getSession().setAttribute("error", error);
                        request.getRequestDispatcher("error.jsp").forward(request, response);
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
