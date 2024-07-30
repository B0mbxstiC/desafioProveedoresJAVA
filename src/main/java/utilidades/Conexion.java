package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static Connection con = null;
	private static final String driver = "org.postgresql.Driver";
	private static final String url = "jdbc:postgresql://localhost:5432/DesafioProveedores";
	private static final String user = "postgres";
	private static final String password = "12345";
	
	public static Connection getConexion() {
		try {
			if (con == null || con.isClosed()) {
				Class.forName(driver);
				System.out.println("Driver JDBC cargado correctamente");
				
				//Establecer la conexion
				con = DriverManager.getConnection(url, user, password);
				System.out.println("Conexión establecida correctamente");
				
				boolean valid = con.isValid(50000);
				System.out.println(valid?"Test Connection Aprove": "Test Connection Failed");
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Error: No se pudo establecer la conexión con la base de datos");
			e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				System.out.println("Error: No se encontró el controlador JDBC");
				e.printStackTrace();
			} catch (Exception e) {
				System.out.println("Error desconocido: " + e);
			}
		
		return con;
		
	}
	
	
}
