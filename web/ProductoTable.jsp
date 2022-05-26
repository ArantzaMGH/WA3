<%-- 
    Document   : ProductoTable
    Created on : 13/05/2022, 01:13:16 AM
    Author     : gerdoc
--%>

<%@page import="org.gerdoc.dao.Producto"%>
<%@page import="org.gerdoc.helper.ProductoHelper"%>
<%@page import="java.util.List"%>
<div class="row">
    <a href="?action=nuevo">
        <button type="button" class="btn btn-outline-primary" >Nuevo</button>
    </a>
    <br/><br/>
</div>
<%
    List<Producto>productoList = null;
    productoList = new ProductoHelper( ).getList( );
    if( productoList == null || productoList.size() == 0 )
    {
%>
        <div class="row mt-4">
            <p>Lista producto sin datos</p>
        </div>
<%            
        return;
    }
%>
        <div class="row">
            <table class="table">
                <thead class="table-primary">
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Url</th>
                        <th>Precio</th>
                        <th>Costo</th>
                    </tr>
                </thead>
<%
    for( Producto producto : productoList)
    {
%>
                <tbody>
                    <tr>
                        <td>
                            <%=producto.getId()%>
                        </td>
                        <td>
                            <%=producto.getNombre()%>
                        </td>
                        <td>
                            <%=producto.getDescripcion()%>
                        </td>
                        <td>
                            <%=producto.getUrl()%>
                        </td>
                        <td>
                            <%=producto.getPrecio()%>
                        </td>
                        <td>
                            <%=producto.getCosto()%>
                        </td>

                    </tr>
                </tbody>
<%
    }
%>
            </table>
        </div>