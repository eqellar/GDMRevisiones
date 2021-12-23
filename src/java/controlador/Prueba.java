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
import dto.UsuarioDTO;
import dto.VehiculoDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Corei3
 */
public class Prueba {

    
    public static void main(String[] args) {
        ResultSet rs = null;
        VehiculoDAO ve = new VehiculoDAO();
        ClienteDAO clie = new ClienteDAO();
        DispositivoDAO dis = new DispositivoDAO();
        UsuarioDAO us = new UsuarioDAO();
        SolicitudDAO soli = new SolicitudDAO();
        FuncionalidadDAO fun = new FuncionalidadDAO();

        List<VehiculoDTO> listvehi = ve.readAll();
        List<ClienteDTO> listclie = clie.readAll();
        List<DispositivoDTO> listdis = dis.readAll();
        List<UsuarioDTO> listus = us.readAll();
        
        
        List<SolicitudDTO> listsoli = soli.readAll();
        List<FuncionalidadDTO> listfun = fun.readAll();

        //boolean num = ve.create(new VehiculoDTO(0, 9, "Nissan", "Tsuru", "2018", "Negro", "Emilio", "XXXXX1"));
        
       //boolean num = dis.create(new DispositivoDTO(0, 5, 115, "123pato", "Falcom", "1111111111", "1"));
        //boolean num = ve.update(new VehiculoDTO(24, 16, "FERRARI", "MURCIELAGO", "2020", "ROJO", "CARJULIO", "XDXD"));
        boolean ex =  soli.update(new SolicitudDTO(1, 1, 4, 1, 1, null, "Porque si", 1, "", "2017-07-21", "", "06:28:24", "", ""));
        //boolean num = soli.update(new SolicitudDTO(1, 1, 4, 1, 1, "2017-06-30 18:46:47", "XDXDXD", 1, "77777", "2017-07-21", "Guanajuato", "06:28:24", "Roberto Macias", "Jorge Luis"));
        
        
       if(ex){
          System.out.println("Registro exitoso");
       }else{
           System.out.println("No se pudo realizar el registro");
       }
        
        
        String usuario = "ecuellar";
        String usu;       
        
        int idusuario = 0;
        
        for (int i = 0; i < listus.size(); i++) {
            usu = listus.get(i).getUsuario();            
            //int contar = plac.length();
            //System.out.println("Esto hay en plac:" + plac +" Mide: "+contar);
            //System.out.println(contar +" Esto hay en plac:"+ plac);
            
            
            if (usu.equals(usuario)) {
                idusuario = listus.get(i).getId_usuario();                
                System.out.println(idusuario+" Las placas son !!!!!!!!!!!!!!!!!!!!!!!!!!!!: " + usuario);
                break;
            }
            else {
                //int con2 = vehiculos.length();               
                System.out.println(" Esto hay en vehi:" + usuario+ " Mide: "+usu);
                
            }
            
        }

        

        String clientes = "Estafeta";
        String cadena;
        int idcliente = 0;   

        for (int i = 0; i < listclie.size(); i++) {
            
            if (listclie.get(i).getAlias().equals(clientes)) {
                idcliente = listclie.get(i).getId_cliente();                
                System.out.println(idcliente+" El cliente es: " + clientes);
                break;
            }
            else {
                
            }
            
        }

     

            if (ex == true) {
                //boolean veri = clie.create(new ClienteDTO(0, "New", "new1", "Andres6")); 
                //boolean veri = us.create(new UsuarioDTO(3, "tes", "tes1", 2, "test", "test"));

                //if(veri == true){
                System.out.println("Registro existoso");
                //}
                //else{
                System.out.println("No fue posible insrtar");
                //}

            }

            for (int i = 0; i < listclie.size(); i++) {

                //System.out.println(lista.get(i).getMarca()+"==>"+lista.get(i).getSubmarca()+"==>"+lista.get(i).getModelo());
                //System.out.println(listclie.get(i).getAlias());
                //System.out.println(listus.get(i).getUsuario());
                //System.out.println(listus.get(i).getNombre());
                //System.out.println(listsoli.get(i).getFecha());
                //System.out.println(listfun.get(i).getNom_abreviado());
            }

        }

    }
