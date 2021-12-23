/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.UsuarioDTO;
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
public class UsuarioDAO implements Obligacion<UsuarioDTO>{
    private static final String SQL_INSERT = "INSERT INTO usuarios (id_usuario, nombre, apellidos, tipo, usuario, password) VALUES (?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE usuarios SET nombre =?, apellidos =?, tipo =?, usuario =?, password =? WHERE id_usuario =?";
    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id_usuario =?";
    private static final String SQL_READ = "SELECT * FROM usuarios WHERE id_usuario =?";
    private static final String SQL_READALL = "SELECT * FROM usuarios";
    
    private static final Conexion con = Conexion.saberEstado();
  

    @Override
    public boolean create(UsuarioDTO c) {
        
        PreparedStatement ps;
        
        try {            
            ps = con.getCnn().prepareStatement(SQL_INSERT);
            
            
            ps.setInt(1, c.getId_usuario());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setInt(4, c.getTipo());
            ps.setString(5, c.getUsuario());
            ps.setString(6, c.getPassword());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        
        return false;
    }

    @Override
    public boolean update(UsuarioDTO u) {
        
        PreparedStatement ps;
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);
            ps.setString(1, u.getNombre());
            ps.setString(2, u.getApellidos());
            ps.setInt(3, u.getTipo());
            ps.setString(4, u.getUsuario());
            ps.setString(5, u.getPassword());
            ps.setInt(6, u.getId_usuario());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
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
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public UsuarioDTO read(Object key) {
        
        PreparedStatement ps;
        ResultSet res;
        UsuarioDTO us = null;
            
        try {
            
            ps = con.getCnn().prepareStatement(SQL_READ);
            ps.setString(1, key.toString());
            res = ps.executeQuery();
            
            while(res.next()){
                us = new UsuarioDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6));
            }
            return us;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return us;
    }

    @Override
    public ArrayList<UsuarioDTO> readAll() {
        PreparedStatement ps;
        ResultSet res;
        ArrayList<UsuarioDTO> usuarios = new ArrayList();
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_READALL);
            res = ps.executeQuery();
            
            while(res.next()){
                usuarios.add(new UsuarioDTO(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getString(5), res.getString(6)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        
        return usuarios;
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
