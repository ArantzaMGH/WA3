/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.helper;

import java.io.Serializable;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.gerdoc.dao.Producto;
import org.gerdoc.service.ProductoService;


/**
 *
 * @author gerdoc
 */
public class ProductoHelper implements Serializable
{
    private List<Producto>list;
    private Producto producto;

    public ProductoHelper() 
    {
    }
    
    public boolean loadList( )
    {
        list = new ProductoService().getProductoList();
        return list != null && list.size() > 0;
    }
    
    public boolean addProducto( HttpServletRequest request )
    {
        producto = new Producto( ); 
        producto.setId( getInteger( request.getParameter( "id" )) );
        if( producto.getId() == 0)
        {
            return false;
        }
        producto.setNombre( request.getParameter( "nombre" ) );
        if( producto.getNombre() == null || producto.getNombre().length() == 0 )
        {
            return false;
        }
        producto.setDescripcion( request.getParameter( "descripcion" ));
        if( producto.getDescripcion() == null || producto.getDescripcion().length() == 0 )
        {
            return false;
        }
        producto.setUrl( request.getParameter( "url" ) );
        if( producto.getUrl() == null || producto.getUrl
        ().length() == 0 )
        {
            return false;
        }
        producto.setPrecio( request.getParameter( "precio" ) );
        if( producto.getPrecio() == null || producto.getPrecio().length() == 0 )
        {
            return false;
        }
        producto.setCosto( request.getParameter( "costo" ) );
        if( producto.getCosto() == null || producto.getCosto().length() == 0 )
        {
            return false;
        }
        return new ProductoService().addProducto(producto);
    }
    
    public Integer getInteger( String campo )
    {
        Integer val = 0;
        if( campo == null || campo.length() == 0 )
        {
            return null;
        }
        try
        {
            val = new Integer(campo);
            return val;
        }
        catch(NumberFormatException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public List<Producto> getList()
    {
        if( list == null || list.size( )== 0 )
        {
            if( !loadList( ) )
            {
                return null;
            }
        }
        return list;
    }

    public void setList(List<Producto> list) 
    {
        this.list = list;
    }

    public Producto getProducto() 
    {
        return producto;
    }

    public void setProducto(Producto producto) 
    {
        this.producto = producto;
    }
    
}
