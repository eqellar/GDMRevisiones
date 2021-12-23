/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.ClienteDTO;
import interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Corei3
 */
public class ClienteDAO implements Obligacion<ClienteDTO>{
    private static final String SQL_INSERT = "INSERT INTO clientes(id_cliente, nombre_clie, alias, vendedor)VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE clientes SET nombre_clie =?, alias =?, vendedor =? WHERE id_cliente =?";
    private static final String SQL_DELETE = "DELETE FROM clientes WHERE id_cliente = ?";
    private static final String SQL_READ = "SELECT * FROM clientes WHERE id_cliente =?";
    private static final String SQL_READALL = "SELECT * FROM clientes";
    
    private static final Conexion con = Conexion.saberEstado();
    
    

    @Override
    public boolean create(ClienteDTO c) {
        
        PreparedStatement ps;
        
        try {           
            
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_cliente());
            ps.setString(2, c.getNombre_clie());
            ps.setString(3, c.getAlias());
            ps.setString(4, c.getVendedor());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(ClienteDTO u) {
        
        PreparedStatement ps;
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, u.getNombre_clie());
            ps.setString(2, u.getAlias());
            ps.setString(3, u.getVendedor());
            ps.setInt(4, u.getId_cliente());
            
            if(ps.executeUpdate() > 0 ){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public ClienteDTO read(Object key) {
        
        PreparedStatement ps;
        ResultSet res;
        ClienteDTO cli = null;
        
        try {
            
            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            res = ps.executeQuery();
            
            while(res.next()){
                cli = new ClienteDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4));                
            }
            return cli;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();                    
        }
        return cli;
    }

    @Override
    public ArrayList<ClienteDTO> readAll() {
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<ClienteDTO> clientes = new ArrayList();
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while(res.next()){
                clientes.add(new ClienteDTO(res.getInt(1), res.getString(2), res.getString(3), res.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return clientes;
    }

    @Override
    public ResultSet getDatos(String consulta) {
        PreparedStatement ps;
        ResultSet res =null;
        try {
            ps = con.getCnn().prepareStatement(consulta);
            res = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        con.cerrarConexion();
    }
        return res;
    }

   
}
