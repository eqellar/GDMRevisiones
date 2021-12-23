/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.ClienteDAO;
import dao.DispositivoDAO;
import dao.FuncionalidadDAO;
import dao.SolicitudDAO;
import dao.UsuarioDAO;
import dao.VehiculoDAO;
import dto.ClienteDTO;
import dto.DispositivoDTO;
import dto.FuncionalidadDTO;
import dto.SolicitudDTO;
import dto.VehiculoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Corei3
 */
public class PruebaActualizar {

    public static void main(String[] args) throws SQLException {
        FuncionalidadDAO fun = new FuncionalidadDAO();
        //fun.update(new FuncionalidadDTO(5, "Paro de motor por boton de panico", "PMPORBP"));
        ClienteDAO clie = new ClienteDAO();
        VehiculoDAO vehi = new VehiculoDAO();
        ArrayList<ClienteDTO> listclie = clie.readAll();
        ArrayList<VehiculoDTO> listvehi = vehi.readAll();
        ArrayList<VehiculoDTO> list2vehi = vehi.readAll2(26);
        VehiculoDTO vehiAbuscar = vehi.read(15);
        UsuarioDAO us = new UsuarioDAO();
        DispositivoDAO dis = new DispositivoDAO();
        List<DispositivoDTO> listdis = dis.readAll();
        SolicitudDAO sol = new SolicitudDAO();
        List<SolicitudDTO> solist = sol.readAll();
        
        VehiculoDTO buscave = vehi.read(4);
        
        String alias = "";
        int idcliente =0;
        int decremento =0;
        String placa ="";
        int idve =0;
        for(int i =0;i< listdis.size(); i++){
            decremento =listdis.get(i).getId_cliente()-1;
            idve = listdis.get(i).getId_vehiculo()-1;
            idcliente = listdis.get(i).getId_cliente();
            alias = listclie.get(decremento).getAlias();
            //System.out.println(i+">"+idcliente+".- "+alias+">>>"+listvehi.get(idve).getPlacas());
            System.out.println(idve);
        }
        
        System.out.println(solist.get(1).getFec_solicitud());
        //System.out.println(listclie.get(3).getId_cliente()+". "+listclie.get(3).getAlias());
        //boolean valid = dis.update(new DispositivoDTO(28, 1, 104, "11111", "HTT", "55555", "No nulo"));
        
        /*
        int idcliente =26;
        int id_cliente = 26;
        String disp = "355797031609201";
        
        String consultaDisp = "SELECT id_dsipositivo, id_cliente, id_vehiculo FROM dispositivos WHERE imei = '"+disp+"'";
        String consulta = "Select * from vehiculos where id_cliente='"+id_cliente+"'";
        
        ResultSet rs = vehi.getDatos(consultaDisp);
        
        while(rs.next()){            
            System.out.println(rs.getString("id_vehiculo"));
                    
        }
        
        
        /*for(int i=0; i < list2vehi.size(); i++){
            System.out.println("Placcas: "+ list2vehi.get(i).getPlacas());
        }
        String nombre = "Ponciano";
        int id_usuario =2;
        int id=26;
        String com = "Select nombre_clie from clientes where id_cliente="+id;
        String consulta = "UPDATE `usuarios` SET `nombre` = '"+nombre+"' WHERE `usuarios`.`id_usuario` = "+id_usuario+"";
        
        String consulta2 = "UPDATE usuarios SET nombre = '"+nombre+"' WHERE id_usuario =" +id_usuario;
        //us.getDatos(consulta);
        
        System.out.println(consulta2);
       
      
      
        /*while (rs.next()){
            nombre = rs.getString("nombre_clie");
            
            System.out.println(nombre);
                    
            
        }*/
       
        
        /*
        String arreglo [] = new String [listclie.size()];
        String arreglo2 [] = new String [listclie.size()];

        for (int i = 0; i < listclie.size(); i++) {
            arreglo[i] ="<option>" + listclie.get(i).getAlias() + "</option>";
            
        }
        arreglo2 = arreglo;
        for(int i =0; i<arreglo2.length; i++){
        System.out.println(arreglo[i]);
        }
        
        //<% for (int i = 0; i < listclie.size(); i++) { %>"<%= listclie.get(i) %>"<%= i + 1 < listclie.size() ? ",":"" %><% } %>
        for (int i = 0; i < listclie.size(); i++) 
        { listclie.get(i);
        
        }

        FuncionalidadDTO busca = fun.read(5);
        System.out.println(busca.getTipo());*/
    }

}
