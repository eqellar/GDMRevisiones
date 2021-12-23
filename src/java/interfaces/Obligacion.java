/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Corei3
 */
public interface Obligacion <Cualquiercosa>{

    public boolean create (Cualquiercosa c);
    public boolean update (Cualquiercosa u);
    public boolean delete (Object key);
    
    public Cualquiercosa read (Object key);
    public List<Cualquiercosa> readAll();
    
    public ResultSet getDatos (String consulta);
        
    
    
}
