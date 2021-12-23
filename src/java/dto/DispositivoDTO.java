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
public class DispositivoDTO {
    private int id_dsipositivo;
    private int id_cliente;
    private int id_vehiculo;
    private String imei;
    private String tipo;
    private String telefono;
    private String num_sim;
    private String fech_instala;
    private String ubicacion;
    private String fech_ult_serv;
    private String tipo_serv;

    public DispositivoDTO() {
    }

    public DispositivoDTO(int id_dsipositivo) {
        this.id_dsipositivo = id_dsipositivo;
    }

    public DispositivoDTO(int id_dsipositivo, int id_cliente, int id_vehiculo, String imei, String tipo, String telefono, String num_sim, String fech_instala, String ubicacion, String fech_ult_serv, String tipo_serv) {
        this.id_dsipositivo = id_dsipositivo;
        this.id_cliente = id_cliente;
        this.id_vehiculo = id_vehiculo;
        this.imei = imei;
        this.tipo = tipo;
        this.telefono = telefono;
        this.num_sim = num_sim;
        this.fech_instala = fech_instala;
        this.ubicacion = ubicacion;
        this.fech_ult_serv = fech_ult_serv;
        this.tipo_serv = tipo_serv;
    }

    public int getId_dsipositivo() {
        return id_dsipositivo;
    }

    public void setId_dsipositivo(int id_dsipositivo) {
        this.id_dsipositivo = id_dsipositivo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNum_sim() {
        return num_sim;
    }

    public void setNum_sim(String num_sim) {
        this.num_sim = num_sim;
    }

    public String getFech_instala() {
        return fech_instala;
    }

    public void setFech_instala(String fech_instala) {
        this.fech_instala = fech_instala;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFech_ult_serv() {
        return fech_ult_serv;
    }

    public void setFech_ult_serv(String fech_ult_serv) {
        this.fech_ult_serv = fech_ult_serv;
    }

    public String getTipo_serv() {
        return tipo_serv;
    }

    public void setTipo_serv(String tipo_serv) {
        this.tipo_serv = tipo_serv;
    }

    
        
}
