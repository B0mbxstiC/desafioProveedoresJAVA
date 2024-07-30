package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.Proveedor;
import utilidades.Conexion;

public class ProveedorDao {
	
	//CRUD
	
	private List<Proveedor> proveedores = new ArrayList<Proveedor>();
	
	
	//Listar todos los proveedores
	
	public List<Proveedor> findAll(){
		ResultSet resultado = null;
		String query = "SELECT * FROM proveedores";
		
		try {
			Connection conexion = Conexion.getConexion();
			Statement statement = conexion.createStatement();
			resultado = statement.executeQuery(query);
			while (resultado.next()) {
				Proveedor proveedor = new Proveedor(resultado.getInt(1), resultado.getString(2), resultado.getString(3), resultado.getString(4), resultado.getString(5), resultado.getString(6), resultado.getString(7), resultado.getString(8));
				proveedores.add(proveedor);
				System.out.println(proveedor);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al obtener los datos de proveedores: " + e);
		}
		return proveedores;
	}
	
	//Encontrar proveedor por Id
	
 	public Proveedor findById(Integer id){
 		ResultSet resultado = null;
 		String query = "SELECT * FROM proveedores WHERE id = " + id;
 		Connection conexion = null;
 		Proveedor proveedor = null;
 		Statement statement = null;
 		
 		try {
 			conexion = Conexion.getConexion();
 			if (conexion == null || conexion.isClosed()) {
				System.out.println("Conexión no establecida o cerrada");
				return null;
			}
			statement = conexion.createStatement();
			resultado = statement.executeQuery(query);
			
			if (resultado.next()) {
				proveedor = new Proveedor(resultado.getInt(1),
						resultado.getString(2), 
						resultado.getString(3), 
						resultado.getString(4), 
						resultado.getString(5), 
						resultado.getString(6), 
						resultado.getString(7), 
						resultado.getString(8)
					);
			}			
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error al establecer conexión con la base de datos: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al obtener los datos del proveedor: " + e);
		} finally {
			try {
				if(resultado != null) resultado.close();
				if (statement != null) statement.close();
				if (conexion != null) conexion.close();
			} catch(SQLException e) {
				System.out.println("Error al cerrar la conexion con la base de datos: " + e.getMessage());
			}
		}
 		System.out.println(proveedor);
 		return proveedor;
 	}
 	
 	//Método para crear proveedores
 	
 	public Integer create(Proveedor proveedor) {
 		Integer resultado = 0;
 		String query = "INSERT INTO public.proveedores(id, nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES("+ proveedor.getId() +", '"+proveedor.getNombre() +"', '"+proveedor.getRut()+"', '"+proveedor.getDireccion()+"', '"+proveedor.getCorreo()+"', '"+proveedor.getTelefono()+"', '"+proveedor.getContacto()+"', '"+proveedor.getTelefonoContacto()+"')";
 		Connection conexion = Conexion.getConexion();
 		
 		try {
			Statement statement = conexion.createStatement();
			resultado = statement.executeUpdate(query);
			if (resultado == 1) {
				System.out.println("Inserción completa");
			} else {
				System.out.println("Inserción fallida");
			}			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Problema al acceder a la información de la base de datos: " + e.getMessage());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error desconocido: " + e);
		}
 		return resultado;
 	}
 	
 	//Método para actualizar proveedores
 	public Integer update(Proveedor proveedores) {
 		Integer resultado = 0;
        String query = "UPDATE proveedores SET nombre = ?, rut = ?, direccion = ?, correo = ?, telefono = ?, contacto = ?, telefono_contacto = ? WHERE id = ?";
 		try(Connection conexion = Conexion.getConexion();
 				PreparedStatement pstmt = conexion.prepareStatement(query)) {
		pstmt.setString(1, proveedores.getNombre());
		pstmt.setString(2, proveedores.getRut());
		pstmt.setString(3, proveedores.getDireccion());
		pstmt.setString(4, proveedores.getCorreo());
		pstmt.setString(5, proveedores.getTelefono());
		pstmt.setString(6, proveedores.getContacto());
		pstmt.setString(7, proveedores.getTelefonoContacto());
		pstmt.setInt(8, proveedores.getId());
 		
		int columnasAfectadas = pstmt.executeUpdate();
		if (columnasAfectadas > 0) {
			System.out.println("Proveedor actualizado exitosamente");
		} else {
			System.out.println("No se encontró el proveedor con el ID señalado");
		}
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
 		return resultado;
 		
 	}
 	
 	
 	//Método para eliminar proveedores
 	public Integer deleteById(Integer id) {
 		Integer resultado = 0;
 		String query = "DELETE FROM proveedores WHERE id = " + id;
		Connection conexion = Conexion.getConexion();
		
		try {
			Statement statement = conexion.createStatement();
			resultado = statement.executeUpdate(query);
			if (resultado == 1) {
				System.out.println("Eliminación exitosa");
			} else {
				System.out.println("Eliminación fallida");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("No se pudo conectar a la base de datos: " + e);
		}
		
 		return resultado;
 	}
 	
 	
 	
 	
 	
	
}
