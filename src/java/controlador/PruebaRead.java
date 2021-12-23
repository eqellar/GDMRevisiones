/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.DispositivoDAO;
import dto.DispositivoDTO;
import java.util.List;

/**
 *
 * @author Corei3
 */
public class PruebaRead {
    
    public static void main(String[] args) {
        DispositivoDAO dis = new DispositivoDAO();
        List<DispositivoDTO> listdis = dis.readAll();
    }
    
}
