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
import org.gerdoc.dao.Producto;

/**
 *
 * @author gerdoc
 */
public class ProductoService 
{

    public ProductoService() 
    {
    }
    
    public List<Producto> getProductoList( )
    {
        List<Producto>productoList = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Producto producto = null;
        
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
            resultSet = statement.executeQuery( "SELECT * FROM TBL_PRODUCTO" );
            if( resultSet == null )
            {
                return null;
            }
            productoList = new ArrayList<>();
            while( resultSet.next() )
            {
                producto = new Producto();
                producto.setId( resultSet.getInt(1) );
               
                producto.setNombre(resultSet.getString(2) );
                
                producto.setDescripcion(resultSet.getString(3) );
                
                producto.setUrl(resultSet.getString(4) );
                
                producto.setPrecio(resultSet.getString(5) );
                
                producto.setCosto(resultSet.getString(6) );
                
                productoList.add(producto);
            }
            resultSet.close();
            MySqlConnection.closeConnection(connection);
            return productoList;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public boolean addProducto( Producto producto )
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO TBL_PRODUCTO(NOMBRE,DESCRIPCION,URL,PRECIO,COSTO) VALUES(?,?,?,?,?)";
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
            preparedStatement.setString(1, producto.getNombre());       
            preparedStatement.setString(2, producto.getDescripcion());
            preparedStatement.setString(3, producto.getUrl());
            preparedStatement.setString(4, producto.getPrecio());
            preparedStatement.setString(5, producto.getCosto());
            
            
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
