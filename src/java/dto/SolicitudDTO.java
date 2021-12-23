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
public class SolicitudDTO {
    private int id_solicitud;
    private int id_dsipositivo;
    private int id_cliente;
    private int id_vehiculo;
    private int id_usuario;
    private String fec_solicitud;
    private String motivo;
    private int estatus;
    private String folio;
    private String fec_agenda;
    private String lugar;
    private String hora;
    private String instalador;
    private String contacto;
    

    public SolicitudDTO() {
    }

    public SolicitudDTO(int id_solicitud) {
        this.id_solicitud = id_solicitud;
    }

    public SolicitudDTO(int id_solicitud, int id_dsipositivo, int id_cliente, int id_vehiculo, int id_usuario, String fec_solicitud, String motivo, int estatus, String folio, String fec_agenda, String lugar, String hora, String instalador, String contacto) {
        this.id_solicitud = id_solicitud;
        this.id_dsipositivo = id_dsipositivo;
        this.id_cliente = id_cliente;
        this.id_vehiculo = id_vehiculo;
        this.id_usuario = id_usuario;
        this.fec_solicitud = fec_solicitud;
        this.motivo = motivo;
        this.estatus = estatus;
        this.folio = folio;
        this.fec_agenda = fec_agenda;
        this.lugar = lugar;
        this.hora = hora;
        this.instalador = instalador;
        this.contacto = contacto;
    }

    public int getId_solicitud() {
        return id_solicitud;
    }

    public void setId_solicitud(int id_solicitud) {
        this.id_solicitud = id_solicitud;
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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFec_solicitud() {
        return fec_solicitud;
    }

    public void setFec_solicitud(String fec_solicitud) {
        this.fec_solicitud = fec_solicitud;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFec_agenda() {
        return fec_agenda;
    }

    public void setFec_agenda(String fec_agenda) {
        this.fec_agenda = fec_agenda;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getInstalador() {
        return instalador;
    }

    public void setInstalador(String instalador) {
        this.instalador = instalador;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    
    
}
