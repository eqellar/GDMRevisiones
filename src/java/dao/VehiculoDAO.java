/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.VehiculoDTO;
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
public class VehiculoDAO implements Obligacion<VehiculoDTO>{
    private static final String SQL_INSERT = "INSERT INTO vehiculos (id_vehiculo, id_cliente, marca, submarca, modelo, color, economico, placas) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE vehiculos SET id_cliente =?, marca =?, submarca =?, modelo =?, color =?, economico =?, placas =? WHERE id_vehiculo =?";
    private static final String SQL_DELETE = "DELETE FROM vehiculos WHERE id_vehiculo =?";
    private static final String SQL_READ = "SELECT * FROM vehiculos WHERE id_vehiculo =?";
    private static final String SQL_READALL = "SELECT * FROM vehiculos";
    private static final String SQL_CLIENTEVEHICULO = "SELECT * FROM vehiculos WHERE id_cliente = ?";
    private static final String SQL_com = "SELECT * FROM vehiculos WHERE id_cliente = ?";
    
    
    private static final Conexion con = Conexion.saberEstado();
    

    @Override
    public boolean create(VehiculoDTO c) {
        
        PreparedStatement ps;
        
        try {            
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_vehiculo());
            ps.setInt(2, c.getId_cliente());
            ps.setString(3, c.getMarca());
            ps.setString(4, c.getSubmarca());
            ps.setString(5, c.getModelo());
            ps.setString(6, c.getColor());
            ps.setString(7, c.getEconomico());
            ps.setString(8, c.getPlacas());
            
            if(ps.executeUpdate() > 0){
                return true;
            }            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        con.cerrarConexion();
    }
        return false;
    }

    @Override
    public boolean update(VehiculoDTO u) {
        
        PreparedStatement ps;
        
        try {          
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, u.getId_cliente());
            ps.setString(2, u.getMarca());
            ps.setString(3, u.getSubmarca());
            ps.setString(4, u.getModelo());
            ps.setString(5, u.getColor());
            ps.setString(6, u.getEconomico());
            ps.setString(7, u.getPlacas());
            ps.setInt(8, u.getId_vehiculo());
            
            if(ps.executeUpdate()> 0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();;
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
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public VehiculoDTO read(Object key) {
        
        PreparedStatement ps;
        ResultSet res;
        VehiculoDTO ve = null;
            
        try {
            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while (res.next()){
                ve = new VehiculoDTO(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8));
                        
                        }
            return ve;
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        
        return ve;
    }

    @Override
    public ArrayList<VehiculoDTO> readAll() {
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<VehiculoDTO> vehiculos = new ArrayList();
            
        try {
            
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            
            res = ps.executeQuery();
            
            while (res.next()){
                vehiculos.add(new VehiculoDTO(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        con.cerrarConexion();
    }
        return vehiculos;
    }

    
    public ArrayList<VehiculoDTO> readAll2(int id_cliente) {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<VehiculoDTO> vehiculos = new ArrayList();
            
        try {
            
            
            ps = con.getCnn().prepareStatement(SQL_CLIENTEVEHICULO);
            ps.setInt(1, id_cliente);
            res = ps.executeQuery();
            
            while (res.next()){
                vehiculos.add(new VehiculoDTO(res.getInt(1), res.getInt(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
        con.cerrarConexion();
    }
        return vehiculos;
    }
    
    @Override
    public ResultSet  getDatos(String consulta) {
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
