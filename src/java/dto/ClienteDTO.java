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
public class ClienteDTO {
    private int id_cliente;
    private String nombre_clie;
    private String alias;
    private String vendedor;

    public ClienteDTO(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public ClienteDTO(int id_cliente, String nombre_clie, String alias, String vendedor) {
        this.id_cliente = id_cliente;
        this.nombre_clie = nombre_clie;
        this.alias = alias;
        this.vendedor = vendedor;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre_clie() {
        return nombre_clie;
    }

    public void setNombre_clie(String nombre_clie) {
        this.nombre_clie = nombre_clie;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }
    
    
    
    
}
