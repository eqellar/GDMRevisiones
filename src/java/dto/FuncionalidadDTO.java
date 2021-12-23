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
public class FuncionalidadDTO {
    private int id_funcion;
    private String tipo;
    private String nom_abreviado;

    public FuncionalidadDTO(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public FuncionalidadDTO(int id_funcion, String tipo, String nom_abreviado) {
        this.id_funcion = id_funcion;
        this.tipo = tipo;
        this.nom_abreviado = nom_abreviado;
    }

    public int getId_funcion() {
        return id_funcion;
    }

    public void setId_funcion(int id_funcion) {
        this.id_funcion = id_funcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNom_abreviado() {
        return nom_abreviado;
    }

    public void setNom_abreviado(String nom_abreviado) {
        this.nom_abreviado = nom_abreviado;
    }
    
    
}
