/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Corei3
 */
public class AplicaDTO {

    private int id_dsipositivo;
    private int id_funcion;

    public AplicaDTO() {
    }

    public AplicaDTO(int id_dsipositivo, int id_funcion) {
        this.id_dsipositivo = id_dsipositivo;
        this.id_funcion = id_funcion;
    }

    public int getId_dsipositivo() {
        return id_dsipositivo;
    }

    public void setId_dsipositivo(int id_dsipositivo) {
        this.id_dsipositivo = id_dsipositivo;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }
    
    
    
    }
