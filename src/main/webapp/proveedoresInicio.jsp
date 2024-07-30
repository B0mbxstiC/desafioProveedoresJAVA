<%@page import="dto.Proveedor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Proveedores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<% List<Proveedor> proveedores = (List<Proveedor>) request.getAttribute("proveedores"); %>
</head>
<body class="bg-secondary text-white">
	
	<div class="Container text-center">
		<h1>Plataforma de ingreso de proveedores</h1>
		<h2 class="my-3">Ingreso de datos del proveedor</h2>
	</div>
	
	
	<div class="container">	
	
	<form class="row py-3" action="Validador" method="post">
	
  <div class="col-md-4 ms-auto py-1">
    <label for="txtId" class="form-label">ID</label>
    <input type="number" class="form-control" id="txtId" name="txtId" required>
  </div>
  
  <div class="col-md-8 ms-auto py-1">
    <label for="txtNombre" class="form-label">Nombre</label>
    <input type="text" class="form-control" id="txtNombre" name="txtNombre" required> 
  </div>
  
  	<!-- Rut -->
  <div class="col-md-4 ms-auto py-3">
    <label for="txtRut" class="form-label">Rut</label>
    <input type="text" class="form-control" id="txtRut" name="txtRut" required>
  </div>
  
  <div class="col-md-8 ms-auto py-3">
    <label for="txtDireccion" class="form-label">Dirección</label>
    <input type="text" class="form-control" id="txtDireccion" name="txtDireccion" required>
  </div>
    
    <div class="col-md-4 ms-auto py-3">
    <label for="txtTelefono" class="form-label">Teléfono</label>
    <input type="text" class="form-control" id="txtTelefono" name="txtTelefono" required>
  </div>
    
  <div class="col-md-8 ms-auto py-3">
    <label for="txtCorreo" class="form-label">Correo</label>
    <input type="text" class="form-control" id="txtCorreo" name="txtCorreo" required>
  </div>    
  
  <div class="col-md-4 ms-auto py-3">
    <label for="txtTelefonoContacto" class="form-label">Teléfono del contacto</label>
    <input type="text" class="form-control" id="txtTelefonoContacto" name="txtTelefonoContacto" required>
  </div>
  
  <div class="col-md-8 ms-auto py-3">
    <label for="txtContacto" class="form-label">Nombre del Contacto</label>
    <input type="text" class="form-control" id="txtContacto" name="txtContacto" required>
  </div>  
	
	<!-- <div class="col-md-5 me-auto">
	<label for="opcion" class="form-label">Elige que quieres hacer</label>
	<select id="opcion" name="opcion" class="form-select">
		<option>Crear cliente nuevo</option>
		<option>Actualizar cliente existente</option>
		<option>Ver la lista de clientes actuales</option>
		<option>Eliminar cliente por ID</option>
	</select>	
	</div> -->
	
  
  <button type="submit" class="btn btn-primary my-3 py-3">Ingresar nuevo cliente</button>
</form>	
	</div>
	
	<div class="container">
		
		<table class="table">
		
	<thead class="table-primary">
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Nombre</th>
      <th scope="col">Rut</th>
      <th scope="col">Dirección</th>
      <th scope="col">Correo</th>
      <th scope="col">Teléfono</th>
      <th scope="col">Contacto</th>
      <th scope="col">Teléfono contacto</th>
      <th scope="col">Eliminar</th>
      <th scope="col">Actualizar</th>      
    </tr>
    </thead>
		
		<tbody>
  <% for(Proveedor proveedorTemporal : proveedores){ %>
    <tr>
      <td><%= proveedorTemporal.getId() %></td>
      <td><%= proveedorTemporal.getNombre() %></td>
      <td><%= proveedorTemporal.getRut() %></td>
      <td><%= proveedorTemporal.getDireccion() %></td>
      <td><%= proveedorTemporal.getCorreo() %></td>
      <td><%= proveedorTemporal.getTelefono() %></td>
      <td><%= proveedorTemporal.getContacto() %></td>
      <td><%= proveedorTemporal.getTelefonoContacto() %></td>
      <td><a href="EliminarPorId?id=<%= proveedorTemporal.getId()%>"><button class="btn btn-danger">Eliminar</button></a></td>
      <td><a href="PreActualizar?idActualizar=<%= proveedorTemporal.getId()%>"><button class="btn btn-success">Actualizar</button></a></td>  
    </tr>
    <% }%>
  </tbody>
		
		</table>
		
	</div>
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>