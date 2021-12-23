/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.SolicitudDTO;
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
public class SolicitudDAO implements Obligacion<SolicitudDTO>{
    private static final String SQL_INSERT = "INSERT INTO solicitud (id_solicitud, id_dsipositivo, id_cliente, id_vehiculo, id_usuario, fec_solicitud, motivo, estatus, folio, fec_agenda, lugar, hora, instalador, contacto ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE solicitud SET id_dsipositivo =?, id_cliente =?, id_vehiculo =?, id_usuario =?, fec_solicitud =?, motivo=?, estatus =?, folio =?, fec_agenda =?, lugar =?, hora =?, instalador =?, contacto =? WHERE id_solicitud =?";
    private static final String SQL_DELETE = "DELETE FROM solicitud WHERE id_solicitud =?";
    private static final String SQL_READ = "SELECT * FROM solicitud WHERE id_solicitud =?";
    private static final String SQL_READALL = "SELECT * FROM solicitud";
    
    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(SolicitudDTO c) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_solicitud());
            ps.setInt(2, c.getId_dsipositivo());
            ps.setInt(3, c.getId_cliente());
            ps.setInt(4, c.getId_vehiculo());
            ps.setInt(5, c.getId_usuario());
            ps.setString(6, c.getFec_solicitud());
            ps.setString(7, c.getMotivo());
            ps.setInt(8, c.getEstatus());
            ps.setString(9, c.getFolio());
            ps.setString(10, c.getFec_agenda());
            ps.setString(11, c.getLugar());
            ps.setString(12, c.getHora());
            ps.setString(13, c.getInstalador());
            ps.setString(14, c.getContacto());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(SolicitudDTO u) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setInt(1, u.getId_dsipositivo());
            ps.setInt(2, u.getId_cliente());
            ps.setInt(3, u.getId_vehiculo());
            ps.setInt(4, u.getId_usuario());
            ps.setString(5, u.getFec_solicitud());            
            ps.setString(6, u.getMotivo());
            ps.setInt(7, u.getEstatus());
            ps.setString(8, u.getFolio());
            ps.setString(9, u.getFec_agenda());
            ps.setString(10, u.getLugar());
            ps.setString(11, u.getHora());
            ps.setString(12, u.getInstalador());
            ps.setString(13, u.getContacto());
            ps.setInt(14, u.getId_solicitud());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
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
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public SolicitudDTO read(Object key) {
            
        PreparedStatement ps;
        ResultSet res;
        SolicitudDTO so = null;
            
        try {
            
            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            res = ps.executeQuery();
            
            while(res.next()){
                so = new SolicitudDTO(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), res.getString(7), res.getInt(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14));
            }
            return so;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return so;
    }

    @Override
    public List<SolicitudDTO> readAll() {
        
        PreparedStatement ps;
            ResultSet res;
            ArrayList<SolicitudDTO> solicitudes = new ArrayList();
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while(res.next()){
                solicitudes.add(new SolicitudDTO(res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getInt(5), res.getString(6), res.getString(7), res.getInt(8), res.getString(9), res.getString(10), res.getString(11), res.getString(12), res.getString(13), res.getString(14)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return solicitudes;
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
