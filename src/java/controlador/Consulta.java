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
import dao.SolicitudDAO;
import dao.UsuarioDAO;
import dao.VehiculoDAO;
import dto.AplicaDTO;
import dto.ClienteDTO;
import dto.DispositivoDTO;
import dto.FuncionalidadDTO;
import dto.SolicitudDTO;
import dto.UsuarioDTO;
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
public class Consulta extends HttpServlet {

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
        DispositivoDAO dis = new DispositivoDAO();
        FuncionalidadDAO fun = new FuncionalidadDAO();
        SolicitudDAO sol = new SolicitudDAO();
        UsuarioDAO us = new UsuarioDAO();
        VehiculoDAO ve = new VehiculoDAO();

        List<ClienteDTO> listclie = clie.readAll();
        List<DispositivoDTO> listdis = dis.readAll();
        List<SolicitudDTO> listsol = sol.readAll();

        String ver = null;
        String searchdis = request.getParameter("searchdis");
        String busimei = request.getParameter("busimei");
        String num = "";
        int idcliente = 0;
        int iddispositivo = 0;
        int idfuncionalidad = 0;
        int idsolicitud = 0;
        int idusuario = 0;
        int idvehiculo = 0;
        String error = "";
        int bandera = 0;

        String nombreclie = "";
        String alias = "";
        String vendedor = "";
        String usutipe = request.getParameter("usutipe");
        String revPendientes = request.getParameter("revPendientes");
        String revAgendadas = request.getParameter("revAgendadas");
        String revAtendidas = request.getParameter("revAtendidas");
        String revCanceladas = request.getParameter("revCanceladas");

        //System.out.println("Esto es ver: " + ver + " Esto es el botón bus: " + searchdis + " Y Estoa es la caja:  " + busimei);

        for (int i = 0; i < listsol.size(); i++) {
            if (ver == null) {
                num = Integer.toString(i);//asigno el valor de i a la variable num convirtiendola en String
                ver = request.getParameter(num); // mando a traer el parametro num que es el nombre del botón submit que manda a este servlet y esto se realiza hasta que el id de la solicitud coincide con la variable i del recorrido del for
            }
        }

        if (busimei.equals("") && searchdis != null&& ver == null) {
            System.out.println("Esto hay en ver:"+ver);
            error = "El dispositivo no existe por favor verifique los datos";
            request.getSession().setAttribute("error", error);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }

        if (searchdis != null && busimei != "" && ver == null) {
            //System.out.println("Entro por btn searchdis "+ searchdis);
            
            for (int j = 0; j < listdis.size(); j++) {
                if (busimei.equals(listdis.get(j).getImei())) {
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

            if (idsolicitud != 0) {
                SolicitudDTO buscasol = sol.read(idsolicitud);//Utilizo la consulta por id de solicitud para depues buscar el ID de la solicitud                
                idcliente = buscasol.getId_cliente();// Capturo el id del cliente en la variable idcliente conforme a el id de la solicitud
                iddispositivo = buscasol.getId_dsipositivo();
                idusuario = buscasol.getId_usuario();
                idvehiculo = buscasol.getId_vehiculo();
                int estatus = buscasol.getEstatus();
                //System.out.println("Estado en numero: "+estatus);
                
                String id_solicitud = Integer.toString(idsolicitud);
                String estado = "";

                if (estatus == 1) {
                    estado = "Pendiente";
                }

                if (estatus == 2) {
                    estado = "Agendada";
                }

                if (estatus == 3) {
                    estado = "Atendida";
                }
                if (estatus == 4) {
                    estado = "Cancelada";
                }
                String fecha_solicitud = buscasol.getFec_solicitud();
                ClienteDTO datoCliente = clie.read(idcliente);//Utilizo la consulta por id del cliente
                alias = datoCliente.getAlias();//Capturo el alias en la varaiable alias
                DispositivoDTO datoDispositivo = dis.read(iddispositivo);
                String imei = datoDispositivo.getImei();
                String fechinstala = datoDispositivo.getFech_instala();
                String ubicacion = datoDispositivo.getUbicacion();
                String fechultserv = datoDispositivo.getFech_ult_serv();
                String tiposerv = datoDispositivo.getTipo_serv();
                VehiculoDTO datoVehiculo = ve.read(idvehiculo);
                String placas = datoVehiculo.getPlacas();
                request.getSession().setAttribute("id_solicitud", id_solicitud);
                request.getSession().setAttribute("alias", alias);//Creo una sesión llamada "alias" con el valor de la variable alias
                request.getSession().setAttribute("imei", imei);
                request.getSession().setAttribute("placas", placas);
                request.getSession().setAttribute("fecha_solicitud", fecha_solicitud);
                request.getSession().setAttribute("estatus", estado);
                request.getSession().setAttribute("fechinstala", fechinstala);
                request.getSession().setAttribute("ubicacion", ubicacion);
                request.getSession().setAttribute("fechultserv", fechultserv);
                request.getSession().setAttribute("tiposerv", tiposerv);

                if (usutipe.equals("1")) {
                    request.getRequestDispatcher("buscaSolicitud.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.

                }
                if (usutipe.equals("2")) {

                }
                if (usutipe.equals("3")) {
                    request.getRequestDispatcher("buscaSolicitud.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.

                }
                if (usutipe.equals("4")) {
                    request.getRequestDispatcher("detallesNoedit.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.
                }
                if (usutipe.equals("5")) {

                }
            }
        }

        if (ver != null && searchdis == null) {
            //System.out.println("Entro por btn ver; "+ver);
            //cuando se ejecuta el submit ver del jsp principal trae como value el id de la solicitud de revisión, es por eso que se realiza esta comparación
            SolicitudDTO buscasol = sol.read(ver);//Utilizo la consulta por id de solicitud para depues buscar el ID de la solicitud                
            idcliente = buscasol.getId_cliente();// Capturo el id del cliente en la variable idcliente conforme a el id de la solicitud
            iddispositivo = buscasol.getId_dsipositivo();
            idusuario = buscasol.getId_usuario();
            idvehiculo = buscasol.getId_vehiculo();
            int estatus = buscasol.getEstatus();
            idsolicitud = buscasol.getId_solicitud();
            String id_solicitud = Integer.toString(idsolicitud);
            String estado = "";
            String folio = buscasol.getFolio();
            String fecha_solicitud = buscasol.getFec_solicitud();
            String motivo = buscasol.getMotivo();
            String contacto = buscasol.getContacto();
            String fecha_agenda = buscasol.getFec_agenda();
            String lugar = buscasol.getLugar();
            String hora = buscasol.getHora();
            String tecnico = buscasol.getInstalador();

            if (estatus == 1) {
                estado = "Pendiente";
            }

            if (estatus == 2) {
                estado = "Agendada";
            }

            if (estatus == 3) {
                estado = "Atendida";
            }
            if (estatus == 4) {
                estado = "Cancelada";
            }
            request.getSession().setAttribute("idsolicitud", id_solicitud);
            request.getSession().setAttribute("estatus", estado);
            request.getSession().setAttribute("folio", folio);
            request.getSession().setAttribute("fecha_solicitud", fecha_solicitud);
            request.getSession().setAttribute("motivo", motivo);
            request.getSession().setAttribute("contacto", contacto);
            request.getSession().setAttribute("fecha_agenda", fecha_agenda);
            request.getSession().setAttribute("lugar", lugar);
            request.getSession().setAttribute("hora", hora);
            request.getSession().setAttribute("tecnico", tecnico);

            AplicaDAO ap = new AplicaDAO();
            List<AplicaDTO> listap = ap.readAll();
            int id_dispositivo = 0;
            ArrayList<String> funcionalidades = new ArrayList<String>();

            for (int j = 0; j < listap.size(); j++) {
                id_dispositivo = listap.get(j).getId_dsipositivo();
                if (id_dispositivo == iddispositivo) {
                    int idfuncion = listap.get(j).getId_funcion();
                    //System.out.println(j + ".-" + listap.get(j).getId_funcion());
                    FuncionalidadDTO buscafuncion = fun.read(idfuncion);
                    //System.out.println("Esto es j: " + j + buscafuncion.getTipo());
                    funcionalidades.add(buscafuncion.getTipo());

                }
            }
            request.getSession().setAttribute("funcionalidades", funcionalidades);


            /*UsuarioDTO datoUsuario = us.read(idusuario);
            String usuario = datoUsuario.getUsuario();
            int nivel = datoUsuario.getTipo();
            request.getSession().setAttribute("usuario", usuario);*/
            ClienteDTO datoCliente = clie.read(idcliente);//Utilizo la consulta por id del cliente
            nombreclie = datoCliente.getNombre_clie();//Capturo el nombre del cliente en la variable nombre
            alias = datoCliente.getAlias();//Capturo el alias en la varaiable alias
            vendedor = datoCliente.getVendedor();//Captu el nobre del vendedor en la varaiable vendedor
            request.getSession().setAttribute("nombreclie", nombreclie);//Creo una sesión llamada "nombre" con el valor de la variable nombre
            request.getSession().setAttribute("alias", alias);//Creo una sesión llamada "alias" con el valor de la variable alias
            request.getSession().setAttribute("vendedor", vendedor);//Creo una sesión llamada "vendedor" con el valor de la variable vendedor
            //System.out.println("Datos del cliente" + nombreclie + ", " + alias + ", " + vendedor); //Prueba de impresión para verificar los valores capturados  

            DispositivoDTO datoDispositivo = dis.read(iddispositivo);
            String imei = datoDispositivo.getImei();
            String tipo = datoDispositivo.getTipo();
            String telefono = datoDispositivo.getTelefono();
            String fechinstala = datoDispositivo.getFech_instala();
            String ubicacion = datoDispositivo.getUbicacion();
            String fechultserv = datoDispositivo.getFech_ult_serv();
            String tiposerv = datoDispositivo.getTipo_serv();

            request.getSession().setAttribute("imei", imei);
            request.getSession().setAttribute("tipo", tipo);
            request.getSession().setAttribute("telefono", telefono);
            request.getSession().setAttribute("fechinstala", fechinstala);
            request.getSession().setAttribute("ubicacion", ubicacion);
            request.getSession().setAttribute("fechultserv", fechultserv);
            request.getSession().setAttribute("tiposerv", tiposerv);

            VehiculoDTO datoVehiculo = ve.read(idvehiculo);
            String marca = datoVehiculo.getMarca();
            String sub_marca = datoVehiculo.getSubmarca();
            String modelo = datoVehiculo.getModelo();
            String color = datoVehiculo.getColor();
            String economico = datoVehiculo.getEconomico();
            String placas = datoVehiculo.getPlacas();
            request.getSession().setAttribute("marca", marca);
            request.getSession().setAttribute("sub_marca", sub_marca);
            request.getSession().setAttribute("modelo", modelo);
            request.getSession().setAttribute("color", color);
            request.getSession().setAttribute("economico", economico);
            request.getSession().setAttribute("placas", placas);
            //System.out.println("Datos del cliente"+imei+", "+tipo+", "+vendedor); //Prueba de impresión para verificar los valores capturados  
            if (usutipe.equals("1")) {
                request.getRequestDispatcher("detalles.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.

            }
            if (usutipe.equals("2")) {

            }
            if (usutipe.equals("3")) {
                request.getRequestDispatcher("detallesLogistica.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.

            }
            if (usutipe.equals("4")) {
                request.getRequestDispatcher("detallesNoedit.jsp").forward(request, response);//Despacho las sesiones antes creadas al jsp detalles.
            }
            if (usutipe.equals("5")) {

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
