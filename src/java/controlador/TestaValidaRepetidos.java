/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.UsuarioDAO;
import dto.UsuarioDTO;
import java.util.ArrayList;

/**
 *
 * @author Corei3
 */
public class TestaValidaRepetidos {
    
    
    
    public static void main(String[] args) {
        UsuarioDAO us = new UsuarioDAO();
    ArrayList<UsuarioDTO> uslist = us.readAll();
    int usu =0;
    String usuario = "sovied";
    String nombre = "Emilio";
    String apellido ="Cuellar";
        
    
    if(nombre != "" && apellido != ""){
        
        for (int i = 0; i < uslist.size(); i++) {
                if (usuario.equals(uslist.get(i).getUsuario())) {
                    usu = 1;
                    //System.out.println("Error, el nombre de usuario ya está en uso, favor de elegir otro");
                    break;
                } else {
                    usu = 2;
                    //System.out.println(uslist.get(i).getUsuario());
                    //System.out.println("Registro existoso");
                }
            }
    }
        System.out.println("usu es igual a: "+usu);
    }
    
}
