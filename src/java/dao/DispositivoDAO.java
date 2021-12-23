/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.DispositivoDTO;
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
public class DispositivoDAO implements Obligacion<DispositivoDTO>{
    private static final String SQL_INSERT = "INSERT INTO dispositivos(id_dsipositivo, id_cliente, id_vehiculo, imei, tipo, telefono, num_sim, fech_instala,ubicacion,fech_ult_serv,tipo_serv) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE dispositivos SET id_cliente =?, id_vehiculo =?, imei =?, tipo =?, telefono =?, num_sim =?, fech_instala =?, ubicacion =?, fech_ult_serv=?,tipo_serv=? WHERE id_dsipositivo =?";
    private static final String SQL_DELETE = "DELETE FROM dispositivos WHERE id_dsipositivo =?";
    private static final String SQL_READ = "SELECT * FROM dispositivos WHERE id_dsipositivo =?";
    private static final String SQL_READALL = "SELECT * FROM dispositivos";
    
    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(DispositivoDTO c) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_dsipositivo());
            ps.setInt(2, c.getId_cliente());
            ps.setInt(3, c.getId_vehiculo());
            ps.setString(4, c.getImei());
            ps.setString(5, c.getTipo());
            ps.setString(6, c.getTelefono());
            ps.setString(7, c.getNum_sim());
            ps.setString(8, c.getFech_instala());
            ps.setString(9, c.getUbicacion());
            ps.setString(10, c.getFech_ult_serv());
            ps.setString(11, c.getTipo_serv());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public boolean update(DispositivoDTO u) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setInt(1, u.getId_cliente());
            ps.setInt(2, u.getId_vehiculo());
            ps.setString(3, u.getImei());
            ps.setString(4, u.getTipo());
            ps.setString(5, u.getTelefono());
            ps.setString(6, u.getNum_sim());
            ps.setString(7, u.getFech_instala());
            ps.setString(8, u.getUbicacion());
            ps.setString(9, u.getFech_ult_serv());
            ps.setString(10, u.getTipo_serv());
            ps.setInt(11, u.getId_dsipositivo());
            
            if(ps.executeUpdate() > 0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        try {
            PreparedStatement ps;
            ps = con.getCnn().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public DispositivoDTO read(Object key) {        
        
        PreparedStatement ps;
        ResultSet res;
        DispositivoDTO dis = null;
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            res = ps.executeQuery();
            
            while(res.next()){
                dis = new DispositivoDTO(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11));
            }
            return dis;
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return dis;
    }

    @Override
    public List<DispositivoDTO> readAll() {
        
        PreparedStatement ps;
        ResultSet res;
        ArrayList<DispositivoDTO> dispositivos = new ArrayList();        
    
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while(res.next()){
                dispositivos.add(new DispositivoDTO(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10), res.getString(11)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DispositivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return dispositivos;
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
