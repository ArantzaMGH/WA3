/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.dao.Provedor;

/**
 *
 * @author gerdoc
 */
public class ProvedorService 
{

    public ProvedorService() 
    {
    }
    
    public List<Provedor> getProvedorList( )
    {
        List<Provedor>provedorList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Provedor provedor = null;
        
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBL_PROVEDOR" );
            if( resultSet == null )
            {
                return null;
            }
            provedorList = new ArrayList<>();
            while( resultSet.next() )
            {
                provedor = new Provedor();
                provedor.setId( resultSet.getInt(1) );
               
                provedor.setNombre(resultSet.getString(2) );
 
                
                provedorList.add(provedor);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return provedorList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addProvedor( Provedor provedor )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_PROVEDOR(NOMBRE) VALUES(?)";
        int row = 0;
        try 
        {
            connection = MySqlConnection.getConnection( );
            if( connection == null )
            {
                return false;
            }
            preparedStatement = connection.prepareStatement(sql);
            if( preparedStatement == null )
            {
                return false;
            }
            preparedStatement.setString(2, provedor.getNombre());      
            
            
            row = preparedStatement.executeUpdate();
            MySqlConnection.closeConnection(connection);
            return row == 1;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
}
