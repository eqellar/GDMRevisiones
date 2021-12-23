/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.AplicaDAO;
import dao.FuncionalidadDAO;
import dto.AplicaDTO;
import dto.FuncionalidadDTO;
import java.util.List;

/**
 *
 * @author Corei3
 */
public class PerubaAplica {
    
    public static void main(String[] args) {
        AplicaDAO ap = new AplicaDAO();
        List<AplicaDTO> listap = ap.readAll();
        FuncionalidadDAO fun = new FuncionalidadDAO();
        
        boolean crea = ap.create(new AplicaDTO(0, 0));
        
        int iddispositivo = 0;
        for(int i = 0; i<listap.size(); i++){
            iddispositivo = listap.get(i).getId_dsipositivo();            
            if(iddispositivo == 4){
                int idfuncion = listap.get(i).getId_funcion();
                System.out.println(i+".-"+listap.get(i).getId_funcion());
                FuncionalidadDTO buscafuncion = fun.read(idfuncion);
                System.out.println(buscafuncion.getTipo());
                
            }            
        }
    }
    
}
