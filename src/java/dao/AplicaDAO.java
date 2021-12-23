/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.AplicaDTO;
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
public class AplicaDAO implements Obligacion<AplicaDTO> {
    private static final String SQL_INSERT = "INSERT INTO aplican(id_dsipositivo, id_funcion)VALUES (?,?)";
    private static final String SQL_UPDATE = "UPDATE aplican SET id_funcion = ? WHERE aplican.id_dsipositivo = ? AND aplican.id_funcion = ?";       
    private static final String SQL_DELETE = "DELETE FROM aplican WHERE id_funcion = ?";
    private static final String SQL_READ = "SELECT * FROM aplican WHERE id_dsipositivo =?";
    private static final String SQL_READALL = "SELECT* FROM aplican";
    
    private static final Conexion con = Conexion.saberEstado();
    
    
    @Override
    public boolean create(AplicaDTO c) {
       PreparedStatement ps;
        
        try {
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            ps.setInt(1, c.getId_dsipositivo());
            ps.setInt(2, c.getId_funcion());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AplicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }return false;
                
    }

    @Override
    public boolean update(AplicaDTO u) {
        try {
            PreparedStatement ps;
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            
            ps.setInt(1, u.getId_dsipositivo());
            ps.setInt(2, u.getId_funcion());
            
            if(ps.executeUpdate()>0){
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AplicaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }return false;
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
    public AplicaDTO read(Object key) {
        PreparedStatement ps;
        ResultSet res;
        AplicaDTO ap = null;
        
        try {            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            
            res = ps.executeQuery();
            
            while(res.next()){
                ap = new AplicaDTO(res.getInt("id_dsipositivo"), res.getInt("id_funcion"));
            }
            return ap;
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();                    
        }
        return ap;
    }

    @Override
    public List<AplicaDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        List<AplicaDTO> listap = new ArrayList();
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while(res.next()){
                listap.add(new AplicaDTO(res.getInt(1), res.getInt(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return listap;
    }

    @Override
    public ResultSet getDatos(String consulta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}
