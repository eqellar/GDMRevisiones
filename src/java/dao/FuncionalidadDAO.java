/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import dto.FuncionalidadDTO;
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
public class FuncionalidadDAO implements Obligacion<FuncionalidadDTO>{
    private static final String SQL_INSER = "INSERT INTO funcinalidades (id_funcion, tipo, nom_abreviado) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE funcinalidades SET tipo =?, nom_abreviado =? WHERE id_funcion =?";
    private static final String SQL_DELETE = "DELETE FROM funcinalidades WHERE id_funcion =?";
    private static final String SQL_RAD = "SELECT * FROM funcinalidades WHERE id_funcion =?";
    private static final String SQL_RADALL = "SELECT * FROM funcinalidades";
    
    private static final Conexion con = Conexion.saberEstado();

    @Override
    public boolean create(FuncionalidadDTO c) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_INSER);
            ps.setInt(1, c.getId_funcion());
            ps.setString(2, c.getNom_abreviado());
            ps.setString(3, c.getTipo());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(FuncionalidadDTO u) {
        
        PreparedStatement ps;
        
        try {
            
            ps = con.getCnn().prepareStatement(SQL_UPDATE);            
            ps.setString(1, u.getTipo());
            ps.setString(2, u.getNom_abreviado());
            ps.setInt(3, u.getId_funcion());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrarConexion();
        }
        return false;
    }

    @Override
    public FuncionalidadDTO read(Object key) {
        
        PreparedStatement ps;
        ResultSet res;
        FuncionalidadDTO fun = null;
        
        try {           
            
            ps = con.getCnn().prepareStatement(SQL_RAD);
            ps.setString(1, key.toString());
            
            res = ps.executeQuery();
            
            while(res.next()){
                fun = new FuncionalidadDTO(res.getInt(1), res.getString(2), res.getString(3));
            }
            return fun;
        } catch (SQLException ex) {
            Logger.getLogger(FuncionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fun;
    }

    @Override
    public ArrayList<FuncionalidadDTO> readAll() {
        
        PreparedStatement ps;
            ResultSet res;
            ArrayList<FuncionalidadDTO> funcionalidades = new ArrayList();
        
        try {            
            
            ps = con.getCnn().prepareStatement(SQL_RADALL);
            res = ps.executeQuery();
            
            while(res.next()){
                funcionalidades.add(new FuncionalidadDTO(res.getInt(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FuncionalidadDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return funcionalidades;
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
