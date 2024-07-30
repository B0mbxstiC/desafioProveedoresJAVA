<%@page import="dto.Proveedor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<% Proveedor proveedorId = (Proveedor) request.getAttribute("proveedorId"); %>
</head>
<body class="bg-secondary text-white">

<div class="container py-5">
		<h1>Actualización de proveedores</h1>
	
	<!-- Datos para actualizar tabla de proveedor -->
	<table class="table my-5">
		
	<thead class="table-primary py-5">
    <tr>
      <th scope="col">Identificador</th>
      <th scope="col">Nombre</th>
      <th scope="col">Rut</th>
      <th scope="col">Dirección</th>
      <th scope="col">Correo</th>
      <th scope="col">Teléfono</th>
      <th scope="col">Contacto</th>
      <th scope="col">Teléfono contacto</th>    
    </tr>
    </thead>
		
		<tbody> 
    <tr>
      <td><%= proveedorId.getId() %></td>
      <td><%= proveedorId.getNombre() %></td>
      <td><%= proveedorId.getRut() %></td>
      <td><%= proveedorId.getDireccion() %></td>
      <td><%= proveedorId.getCorreo() %></td>
      <td><%= proveedorId.getTelefono() %></td>
      <td><%= proveedorId.getContacto() %></td>
      <td><%= proveedorId.getTelefonoContacto() %></td>
    </tr>

  </tbody>
		
		</table>
	
	<div class="container">	
	
	<!-- Formulario para ingresar nuevos datos -->
	<h2>Ingresa los datos nuevos</h2>
	<form class="row py-1" action="Actualizar" method="post">
		  <input type="hidden" name="txtId" value="${proveedorId.getId()}">
		  
		  <div class="col-md-8 ms-auto py-1">
		    <label for="txtNombre" class="form-label">Nombre</label>
		    <input type="text" class="form-control" id="txtNombre" name="txtNombre" required> 
		  </div>
		  
		  	<!-- Rut -->
		  <div class="col-md-4 ms-auto py-1">
		    <label for="txtRut" class="form-label">Rut</label>
		    <input type="text" class="form-control" id="txtRut" name="txtRut" required>
		  </div>
		  
		  <div class="col-md-8 ms-auto py-1">
		    <label for="txtDireccion" class="form-label">Dirección</label>
		    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" required>
		  </div>
		    
		    <div class="col-md-4 ms-auto py-1">
		    <label for="txtTelefono" class="form-label">Teléfono</label>
		    <input type="text" class="form-control" id="txtTelefono" name="txtTelefono" required>
		  </div>
		    
		  <div class="col-md-8 ms-auto py-1">
		    <label for="txtCorreo" class="form-label">Correo</label>
		    <input type="text" class="form-control" id="txtCorreo" name="txtCorreo" required>
		  </div>    
		  
		  <div class="col-md-4 ms-auto py-1">
		    <label for="txtTelefonoContacto" class="form-label">Teléfono del contacto</label>
		    <input type="text" class="form-control" id="txtTelefonoContacto" name="txtTelefonoContacto" required>
		  </div>
		  
		  <div class="col-md-12 ms-auto py-1">
		    <label for="txtContacto" class="form-label">Nombre del Contacto</label>
		    <input type="text" class="form-control" id="txtContacto" name="txtContacto" required>
		  </div>  		
		  
		  <button type="submit" class="btn btn-primary my-3 py-4 mx-auto">Actualizar proveedor</button>	
	</form>
	</div>	
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</body>
</html>