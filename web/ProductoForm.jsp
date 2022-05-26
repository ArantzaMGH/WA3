    <%-- 
    Document   : UnoForm
    Created on : 13/05/2022, 01:34:33 AM
    Author     : gerdoc
--%>
<form action="ProductoList.jsp">
    <div class="row mt-4 grey">
        <div class="col">
            <div class="mb-3 mt-3">
                
                <label for="id">Id de producto:</label>
                <input type="text" class="form-control" id="id" placeholder="Escribe el id del producto" name="id">
            </div>
        </div>

        <div class="col">
            <div class="mb-3 mt-3">
                <label for="nombre">Escribe el nombre:</label>
                <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre">
            </div>
        </div>

        <div class="col">
            <div class="mb-3 mt-3">
                <label for="descripcion">Escribe la descripción:</label>
                <input type="text" class="form-control" id="descripcion" placeholder="Descripción" name="descripcion">
            </div>
        </div>

        <div class="col">
            <div class="mb-3 mt-3">
                <label for="url">Escribe el URL:</label>
                <input type="text" class="form-control" id="url" placeholder="URL" name="url">
            </div>
        </div>

        <div class="col">
            <div class="mb-3 mt-3">
                <label for="precio">Escribe el precio:</label>
                <input type="text" class="form-control" id="precio" placeholder="Precio" name="Precio">
            </div>
        </div>

        <div class="col">
            <div class="mb-3 mt-3">
                <label for="costo">Escribe el costo:</label>
                <input type="text" class="form-control" id="costo" placeholder="Costo" name="costo">
            </div>
        </div>

    </div>
    <div class="row mt-4 grey">
        <input type="hidden" id="action" name="action" value="send" />
        <div class=""input-group mb-3">
            <button type="submit" class="btn btn-primary">Enviar</button>
            <button type="reset" class="btn btn-primary">Borrar</button>
        </div>
    </div>
</form>
<br/>
<div class="row mt-6">
    <a href="?">
        <button type="button" class="btn btn-outline-primary" >Regresar</button>
    </a>
</div>
