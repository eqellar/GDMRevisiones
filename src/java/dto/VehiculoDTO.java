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
public class VehiculoDTO {
    private int id_vehiculo;
    private int id_cliente;
    private String marca;
    private String submarca;
    private String modelo;
    private String color;
    private String economico;
    private String placas;

    public VehiculoDTO() {
    }

    public VehiculoDTO(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public VehiculoDTO(int id_vehiculo, int id_cliente, String marca, String submarca, String modelo, String color, String economico, String placas) {
        this.id_vehiculo = id_vehiculo;
        this.id_cliente = id_cliente;
        this.marca = marca;
        this.submarca = submarca;
        this.modelo = modelo;
        this.color = color;
        this.economico = economico;
        this.placas = placas;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSubmarca() {
        return submarca;
    }

    public void setSubmarca(String submarca) {
        this.submarca = submarca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEconomico() {
        return economico;
    }

    public void setEconomico(String economico) {
        this.economico = economico;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }
    
    
    
    
    


}